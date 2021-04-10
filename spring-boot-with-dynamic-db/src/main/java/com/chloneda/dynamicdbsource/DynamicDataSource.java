package com.chloneda.dynamicdbsource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Created by chloneda
 * @Description:
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSource();
    }
    
}
