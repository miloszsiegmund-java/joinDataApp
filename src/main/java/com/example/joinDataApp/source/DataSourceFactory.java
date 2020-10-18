package com.example.joinDataApp.source;

import com.example.joinDataApp.strategy.IFetchDataStrategy;

public interface DataSourceFactory<T> {
    IFetchDataStrategy<T> createDataSourceStrategy(DataSourceType dataSource);
}
