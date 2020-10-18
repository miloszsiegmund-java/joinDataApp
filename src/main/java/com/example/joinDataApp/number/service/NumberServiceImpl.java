package com.example.joinDataApp.number.service;

import com.example.joinDataApp.source.DataSourceType;
import com.example.joinDataApp.strategy.IJoinDataStrategy;
import com.example.joinDataApp.strategy.MethodType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NumberServiceImpl implements NumberService {

    private final List<IJoinDataStrategy<Integer>> list;
    private static final String MESSAGE = "Method not support ";

    @Override
    public Integer sum(MethodType methodType, DataSourceType firstSource, DataSourceType secondSource) {
        return getJoinDataStrategy(methodType).joinData(firstSource, secondSource);
    }


    private IJoinDataStrategy<Integer> getJoinDataStrategy(MethodType methodType) {
        return list
                .stream()
                .filter(item -> item.accept(methodType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE + methodType));
    }

}
