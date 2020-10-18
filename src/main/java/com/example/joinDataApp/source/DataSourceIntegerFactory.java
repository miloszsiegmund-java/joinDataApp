package com.example.joinDataApp.source;

import com.example.joinDataApp.number.client.ApiNumberClient;
import com.example.joinDataApp.number.client.RandomGenerateNumberClient;
import com.example.joinDataApp.strategy.IFetchDataStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSourceIntegerFactory implements DataSourceFactory<Integer> {

    private final IFetchDataStrategy<Integer> apiFetchData = new ApiNumberClient();
    private final IFetchDataStrategy<Integer> randomFetchData = new RandomGenerateNumberClient();

    @Override
    public IFetchDataStrategy<Integer> createDataSourceStrategy(DataSourceType dataSource) {
        switch (dataSource) {
            case API:
                return apiFetchData;
            case RANDOM:
                return randomFetchData;
            default:
                throw new IllegalArgumentException();
        }
    }
}
