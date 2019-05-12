package com.orjrs.jdbcms.config;

import com.sun.istack.internal.Nullable;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author liujun22
 * CreateDate:2019/3/10 19:24
 */
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
