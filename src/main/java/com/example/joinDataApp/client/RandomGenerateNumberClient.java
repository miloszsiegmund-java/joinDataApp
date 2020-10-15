package com.example.joinDataApp.client;

import com.example.joinDataApp.criteria.RandomCriteria;
import com.example.joinDataApp.strategy.IFetchDataStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class RandomGenerateNumberClient implements IFetchDataStrategy<Integer> {

    private final RandomCriteria randomCriteria;


    @Override
    public Integer fetchData() {
        Random r = new Random();
        return r.nextInt(randomCriteria.getMax());
    }
}
