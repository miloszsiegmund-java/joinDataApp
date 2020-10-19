package com.example.joinDataApp.number.criteria;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ApiCriteria {

    private static Integer MIN;
    private static Integer MAX;

    @Value("${api.criteria.max}")
    private void setMax(Integer max) {
        MAX = max;
    }

    @Value("${api.criteria.min}")
    private void setMin(Integer min) {
        MIN = min;
    }

    public static Integer getMIN() {
        return MIN;
    }

    public static Integer getMAX() {
        return MAX;
    }
}
