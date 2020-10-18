package com.example.joinDataApp.number.criteria;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class RandomCriteria {

    private static Integer MAX;

    public static Integer getMAX() {
        return MAX;
    }

    @Value("${generate.random.criteria.max}")
    public void setMAX(Integer max) {
        MAX = max;
    }
}
