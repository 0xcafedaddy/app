package com.uflowertv.datasources;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 获得数据源
 */
public class MultipleDataSource extends AbstractRoutingDataSource{

    @Override
    protected Object determineCurrentLookupKey() {
         return DynamicDataSourceHolder.getRouteKey();
    }
}