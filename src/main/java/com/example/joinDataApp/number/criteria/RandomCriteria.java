package com.example.joinDataApp.number.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class RandomCriteria {

    @Value("${generate.random.criteria.max}")
    private Integer max;
}
