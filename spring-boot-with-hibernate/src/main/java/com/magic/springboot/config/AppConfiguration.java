package com.magic.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Created by chloneda
 * @Description:
 */
@Configuration
@EnableConfigurationProperties({DruidProperties.class, HibernateProperties.class})
@ConditionalOnMissingClass
public class AppConfiguration {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DruidProperties druidProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean(name = "dataSource")
    @ConditionalOnMissingBean
    public DataSource setDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidProperties.getDriverClassName());
        dataSource.setUrl(druidProperties.getUrl());
        dataSource.setUsername(druidProperties.getUsername());
        dataSource.setPassword(druidProperties.getPassword());
        try {
            dataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }


    @Bean(name = "sessionFactory")
    @ConditionalOnMissingBean
    public LocalSessionFactoryBean setSessionFactory(DataSource dataSource){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql",String.valueOf(hibernateProperties.isShowSql()));
        properties.setProperty("hibernate.use_sql_comments",String.valueOf(hibernateProperties.getUseSqlComments()));
        properties.setProperty("hibernate.dialect",String.valueOf(hibernateProperties.getDialect()));
        properties.setProperty("hibernate.use_outer_join",String.valueOf(hibernateProperties.isUseOuterJoin()));
        properties.setProperty("hibernate.query.factory_class",String.valueOf(hibernateProperties.getQuery().getFactoryClass()));
        properties.setProperty("hibernate.format_sql",String.valueOf(hibernateProperties.isShowSql()));
        properties.setProperty("hibernate.hbm2ddl.auto",String.valueOf(hibernateProperties.getHbm2ddl()));
        properties.setProperty("hibernate.query.substitutions",String.valueOf(hibernateProperties.getQuery().getSubstitutions()));
        properties.setProperty("hibernate.query.jpaql_strict_compliance",String.valueOf(hibernateProperties.getQuery().isJpaqlStrictCompliance()));
        properties.setProperty("hibernate.jdbc.fetch_size",String.valueOf(hibernateProperties.getJdbc().getFetchSize()));
        properties.setProperty("hibernate.jdbc.batch_size",String.valueOf(hibernateProperties.getJdbc().getBatchSize()));
        properties.setProperty("hibernate.jdbc.sql_exception_converter",String.valueOf(hibernateProperties.getJdbc().getSqlExceptionConverter()));
        properties.setProperty("hibernate.jdbc.wrap_result_sets",String.valueOf(hibernateProperties.getJdbc().isWrapResultSets()));
        properties.setProperty("hibernate.jdbc.use_streams_for_binary",String.valueOf(hibernateProperties.getJdbc().isUseStreamsForBinary()));
        properties.setProperty("hibernate.jdbc.use_scrollable_resultset",String.valueOf(hibernateProperties.getJdbc().isUseScrollableResultset()));
        properties.setProperty("hibernate.jdbc.factory_class",String.valueOf(hibernateProperties.getJdbc().getFactoryClass()));
        properties.setProperty("hibernate.jdbc.use_get_generated_keys",String.valueOf(hibernateProperties.getJdbc().isUseGetGeneratedKeys()));
        properties.setProperty("hibernate.cache.jndi",String.valueOf(hibernateProperties.getCache().isJndi()));
        properties.setProperty("hibernate.cache.use_second_level_cache",String.valueOf(hibernateProperties.getCache().isUseSecondLevelCache()));
        properties.setProperty("hibernate.cache.use_structured_entries",String.valueOf(hibernateProperties.getCache().isUseStructuredEntries()));
        properties.setProperty("hibernate.cache.use_query_cache",String.valueOf(hibernateProperties.getCache().isUseStructuredEntries()));
        properties.setProperty("hibernate.cache.use_minimal_puts",String.valueOf(hibernateProperties.getCache().isUseQueryCache()));
        properties.setProperty("hibernate.cache.provider_class",String.valueOf(hibernateProperties.getCache().getProviderClass()));
        properties.setProperty("hibernate.cache.provider_configuration_file_resource_path",String.valueOf(hibernateProperties.getCache().getProviderConfigurationFileResourcePath()));
        properties.setProperty("hibernate.cache.query_cache_factory",String.valueOf(hibernateProperties.getCache().getQueryCacheFactory()));
        properties.setProperty("hibernate.cache.region_prefix",String.valueOf(hibernateProperties.getCache().getRegionPrefix()));

        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setPackagesToScan(hibernateProperties.getPackagesToScan());
        sessionFactory.setDataSource(dataSource);
        return sessionFactory;
    }

    @Bean(name = "transactionManager")
    @ConditionalOnMissingBean
    public HibernateTransactionManager setHibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
