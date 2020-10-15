package com.example.joinDataApp.number.criteria;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ApiCriteria {

    @Value("${api.criteria.min}")
    private Integer min;

    @Value("${api.criteria.max}")
    private Integer max;
}
