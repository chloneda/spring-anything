package com.magic.springboot.dynamicdbsource;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chl on 2019/01/11
 * Description:数据源初始化
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSourceRegister.class);
    // 如配置文件中未指定数据源类型，使用该默认值
    private static final String DATASOURCE_DEFAULT_TYPE = "org.apache.tomcat.jdbc.pool.DataSource";

    private DataSource defaultDataSource;
    private Map<String, DataSource> slavesDataSource = new HashMap<String, DataSource>();

    private ConversionService conversionService = new DefaultConversionService();
    private PropertyValues dataSourcePropertyValues;

    private int initialSize;
    private int minIdle;
    private int maxActive;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;
    private String connectionProperties;

    @Override
    public void setEnvironment(Environment env) {
        initDruidProperties(env);
        initDefaultDataSource(env);
        initSlavesDataSource(env);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanRegistry) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        // 将主数据源添加到更多数据源中
        targetDataSources.put("dataSource", defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        // 添加更多数据源
        targetDataSources.putAll(slavesDataSource);
        for (String key : slavesDataSource.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }

        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        beanRegistry.registerBeanDefinition("dataSource", beanDefinition);

        LOGGER.info("Dynamic DataSource Registry");
    }

    /**
     * @param env
     */
    private void initDruidProperties(Environment env) {
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "druid.");
        filters = propertyResolver.getProperty("filters");
        maxWait = Long.parseLong(propertyResolver.getProperty("maxWait"));
        validationQuery = propertyResolver.getProperty("validationQuery");
        minIdle = Integer.parseInt(propertyResolver.getProperty("minIdle"));
        maxActive = Integer.parseInt(propertyResolver.getProperty("maxActive"));
        initialSize = Integer.parseInt(propertyResolver.getProperty("initialSize"));
        testOnBorrow = Boolean.parseBoolean(propertyResolver.getProperty("testOnBorrow"));
        testOnReturn = Boolean.parseBoolean(propertyResolver.getProperty("testOnReturn"));
        testWhileIdle = Boolean.parseBoolean(propertyResolver.getProperty("testWhileIdle"));
        poolPreparedStatements = Boolean.parseBoolean(propertyResolver.getProperty("poolPreparedStatements"));
        minEvictableIdleTimeMillis = Long.parseLong(propertyResolver.getProperty("minEvictableIdleTimeMillis"));
        timeBetweenEvictionRunsMillis = Long.parseLong(propertyResolver.getProperty("timeBetweenEvictionRunsMillis"));
        maxPoolPreparedStatementPerConnectionSize = Integer.parseInt(propertyResolver.getProperty("maxPoolPreparedStatementPerConnectionSize"));
        connectionProperties = propertyResolver.getProperty("connectionProperties");
    }

    private void initDefaultDataSource(Environment env) {
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "master.datasource.");
        Map<String, Object> dsPropMap = new HashMap<String, Object>();
        dsPropMap.put("type", propertyResolver.getProperty("type"));
        dsPropMap.put("driverClassName", propertyResolver.getProperty("driverClassName"));
        dsPropMap.put("url", propertyResolver.getProperty("url"));
        dsPropMap.put("username", propertyResolver.getProperty("username"));
        dsPropMap.put("password", propertyResolver.getProperty("password"));
        defaultDataSource = buildDataSource(dsPropMap);
        bindDataSource(defaultDataSource, env);
    }

    private void bindDataSource(DataSource dataSource, Environment env) {
        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
        dataBinder.setConversionService(conversionService);
        dataBinder.setIgnoreNestedProperties(false);
        dataBinder.setIgnoreInvalidFields(false);
        dataBinder.setIgnoreUnknownFields(true);
        if (dataSourcePropertyValues == null) {
            Map<String, Object> rpr = new RelaxedPropertyResolver(env, "master.datasource").getSubProperties(".");
            Map<String, Object> values = new HashMap<>(rpr);
            // 排除已经设置的属性
            values.remove("type");
            values.remove("driverClassName");
            values.remove("url");
            values.remove("username");
            values.remove("password");
            dataSourcePropertyValues = new MutablePropertyValues(values);
        }
        dataBinder.bind(dataSourcePropertyValues);
    }

    private DataSource buildDataSource(Map<String, Object> dsMap) {
        Object type = dsMap.get("type");
        if (type == null) {
            type = DATASOURCE_DEFAULT_TYPE;
        }
        try {
            Class<? extends DataSource> dataSourceType = (Class<? extends DataSource>) Class.forName((String)type);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dsMap.get("driverClassName").toString());
        druidDataSource.setUrl(dsMap.get("url").toString());
        druidDataSource.setUsername(dsMap.get("username").toString());
        druidDataSource.setPassword(dsMap.get("password").toString());

        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setConnectionProperties(connectionProperties);

        try {
            druidDataSource.setFilters(filters);
            druidDataSource.init();
        } catch (SQLException e) {
            LOGGER.info("======> 数据源初始化异常!");
            e.printStackTrace();
        }

        return druidDataSource;
    }

    private void initSlavesDataSource(Environment env) {
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "slave.datasource.");
        String dsPrefixs = propertyResolver.getProperty("sources");
        for (String dataSourcePrefix : dsPrefixs.split(",")) {
            Map<String,Object> dsMap=propertyResolver.getSubProperties(dataSourcePrefix+".");
            DataSource dataSource=buildDataSource(dsMap);
            slavesDataSource.put(dataSourcePrefix,dataSource);
            bindDataSource(dataSource,env);
        }
    }
}
