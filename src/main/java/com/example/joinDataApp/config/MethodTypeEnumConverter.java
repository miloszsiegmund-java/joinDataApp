package com.example.joinDataApp.config;

import com.example.joinDataApp.strategy.MethodType;
import org.springframework.core.convert.converter.Converter;

public class MethodTypeEnumConverter implements Converter<String, MethodType> {
    @Override
    public MethodType convert(String s) {
        return MethodType.valueOf(s.toUpperCase());
    }
}
