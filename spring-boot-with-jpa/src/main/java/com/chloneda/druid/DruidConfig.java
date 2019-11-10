package com.chloneda.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Created by chloneda
 * @Description:
 */
@Configuration
public class DruidConfig {
    @Value("${spring.datasource.driverClassName}")
    private String driverName;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;

    @Bean
    public DataSource initDruidDataSource(){
        DruidDataSourceFactory druidDataSourceFactory=new DruidDataSourceFactory();
        Properties properties=new Properties();

        properties.setProperty(DruidDataSourceFactory.PROP_DRIVERCLASSNAME,driverName);
        properties.setProperty(DruidDataSourceFactory.PROP_URL,url);
        properties.setProperty(DruidDataSourceFactory.PROP_USERNAME,username);
        properties.setProperty(DruidDataSourceFactory.PROP_PASSWORD,password);

        properties.setProperty(DruidDataSourceFactory.PROP_MAXWAIT,"60000");
        properties.setProperty(DruidDataSourceFactory.PROP_VALIDATIONQUERY,"select 1");
        properties.setProperty(DruidDataSourceFactory.PROP_TESTONBORROW,"true");
        properties.setProperty(DruidDataSourceFactory.PROP_INITIALSIZE,"3");
        properties.setProperty(DruidDataSourceFactory.PROP_MINIDLE,"3");
        properties.setProperty(DruidDataSourceFactory.PROP_MAXACTIVE,"50");
        properties.setProperty(DruidDataSourceFactory.PROP_TESTWHILEIDLE,"true");
        properties.setProperty(DruidDataSourceFactory.PROP_REMOVEABANDONED,"true");
        properties.setProperty(DruidDataSourceFactory.PROP_REMOVEABANDONEDTIMEOUT,"1800");
        properties.setProperty(DruidDataSourceFactory.PROP_TIMEBETWEENEVICTIONRUNSMILLIS,"600000");
        properties.setProperty(DruidDataSourceFactory.PROP_EXCEPTION_SORTER,"0");
        try {
            return druidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName(driverName);
//        druidDataSource.setUrl(url);
//        druidDataSource.setUsername(username);
//        druidDataSource.setPassword(password);
//
//        try {
//            druidDataSource.init();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return druidDataSource;


//        DataSourceBuilder factory = DataSourceBuilder.create()
//                .driverClassName(driverName)
//                .url(url)
//                .username(username)
//                .password(password);
//
//        return factory.build();

        return null;
    }


}
