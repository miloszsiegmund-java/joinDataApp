package com.example.joinDataApp.strategy;

import com.example.joinDataApp.source.DataSourceType;

public interface IJoinDataStrategy<T> {
    boolean accept(MethodType methodType);
    T joinData(DataSourceType firstDataSource, DataSourceType secondDataSource);
}