package com.example.joinDataApp.number.service;

import com.example.joinDataApp.number.exeptions.CustomExceptionHandler;
import com.example.joinDataApp.strategy.IJoinDataStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SumNumberStrategy implements IJoinDataStrategy<Integer> {

    private static final String ERROR_MESSAGE = "error.value";
    private final MessageSource messageSource;

    @Override
    public Integer joinData(Integer firstValue, Integer secondValue) throws CustomExceptionHandler {
        if (firstValue == null || secondValue == null) {
            throw new CustomExceptionHandler(messageSource.getMessage(ERROR_MESSAGE, new Object[0], LocaleContextHolder.getLocale()));

        }
        return firstValue + secondValue;
    }
}