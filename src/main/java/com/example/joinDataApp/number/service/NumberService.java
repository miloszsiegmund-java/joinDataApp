package com.example.joinDataApp.number.service;

import com.example.joinDataApp.source.DataSourceType;
import com.example.joinDataApp.strategy.MethodType;

public interface NumberService {

    Integer sum(MethodType methodType, DataSourceType firstSource, DataSourceType secondSource);
}
