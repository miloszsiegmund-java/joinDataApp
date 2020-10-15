package com.example.joinDataApp.client;

import com.example.joinDataApp.criteria.ApiCriteria;
import com.example.joinDataApp.strategy.IFetchDataStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class ApiNumberClient implements IFetchDataStrategy<Integer> {

    private static final String URL = "https://www.random.org/integers/";
    private static final String NUM = "num";
    private static final Integer NUM_VALUE = 1;
    private static final String MIN = "min";
    private static final String MAX = "max";
    private static final String COL = "col";
    private static final Integer COL_VALUE = 1;
    private static final String BASE = "base";
    private static final Integer BASE_VALUE = 10;
    private static final String FORMAT = "format";
    private static final String FORMAT_VALUE = "plain";
    private static final String RND = "rnd";
    private static final String RND_VALUE = "new";

    private final ApiCriteria apiCriteria;
    private final RestTemplate restTemplate;

    @Override
    public Integer fetchData() throws HttpStatusCodeException {

        try {
            UriComponentsBuilder urlRestApiRandomInt = UriComponentsBuilder.fromHttpUrl(URL)
                    .queryParam(NUM, NUM_VALUE)
                    .queryParam(MIN, apiCriteria.getMin())
                    .queryParam(MAX, apiCriteria.getMax())
                    .queryParam(COL, COL_VALUE)
                    .queryParam(BASE, BASE_VALUE)
                    .queryParam(FORMAT, FORMAT_VALUE)
                    .queryParam(RND, RND_VALUE);

            String valueAsString = restTemplate.getForObject(urlRestApiRandomInt.toUriString(), String.class);

            return Integer.valueOf(valueAsString.trim());
        } catch (HttpStatusCodeException e) {
            return null;
        }
    }
}
