package com.example.joinDataApp.number.service;

import com.example.joinDataApp.strategy.IFetchDataStrategy;
import com.example.joinDataApp.strategy.IJoinDataStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberServiceImpl implements NumberService{

    private final IJoinDataStrategy<Integer> iJoinDataStrategy;
    private final IFetchDataStrategy<Integer> apiNumberClient;
    private final IFetchDataStrategy<Integer> randomGenerateNumberClient;

    public Integer sum() {
        return iJoinDataStrategy.joinData(apiNumberClient.fetchData(), randomGenerateNumberClient.fetchData());
    }


}
