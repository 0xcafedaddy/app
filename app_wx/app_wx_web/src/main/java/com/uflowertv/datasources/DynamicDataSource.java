package com.uflowertv.datasources;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 取得当前使用哪个数据源
 * @return
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getRouteKey();
    }
}