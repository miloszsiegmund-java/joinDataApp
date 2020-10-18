package com.example.joinDataApp.number.client;

import com.example.joinDataApp.number.criteria.RandomCriteria;
import com.example.joinDataApp.strategy.IFetchDataStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class RandomGenerateNumberClient implements IFetchDataStrategy<Integer> {

    private final Random random = new Random();

    @Override
    public Integer fetchData() {
        return random.nextInt(RandomCriteria.getMAX());
    }
}
