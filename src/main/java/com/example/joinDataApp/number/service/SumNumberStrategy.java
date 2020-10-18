package com.example.joinDataApp.number.service;

import com.example.joinDataApp.number.exeptions.CustomExceptionHandler;
import com.example.joinDataApp.source.DataSourceIntegerFactory;
import com.example.joinDataApp.source.DataSourceType;
import com.example.joinDataApp.strategy.IJoinDataStrategy;
import com.example.joinDataApp.strategy.MethodType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SumNumberStrategy implements IJoinDataStrategy<Integer> {

    private static final String ERROR_MESSAGE = "error.value";
    private final DataSourceIntegerFactory dateSourceFactory;
    private final MessageSource messageSource;

    @Override
    public boolean accept(MethodType methodType) {
        return methodType == MethodType.SUM;
    }

    @Override
    public Integer joinData(DataSourceType firstSource, DataSourceType secondSource) throws CustomExceptionHandler {
        if (firstSource == null || secondSource == null) {
            throw new CustomExceptionHandler(messageSource.getMessage(ERROR_MESSAGE, new Object[0], LocaleContextHolder.getLocale()));

        }
        Integer firstValue = dateSourceFactory.createDataSourceStrategy(firstSource).fetchData();
        Integer secondValue = dateSourceFactory.createDataSourceStrategy(secondSource).fetchData();

        if (firstValue == null || secondValue == null) {
            throw new CustomExceptionHandler(messageSource.getMessage(ERROR_MESSAGE, new Object[0], LocaleContextHolder.getLocale()));
        }
        return firstValue + secondValue;

    }
}