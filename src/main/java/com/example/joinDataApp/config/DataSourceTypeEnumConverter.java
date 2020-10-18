package com.example.joinDataApp.config;

import com.example.joinDataApp.source.DataSourceType;
import org.springframework.core.convert.converter.Converter;

public class DataSourceTypeEnumConverter implements Converter<String, DataSourceType> {
    @Override
    public DataSourceType convert(String s) {
        return DataSourceType.valueOf(s.toUpperCase());
    }
}
