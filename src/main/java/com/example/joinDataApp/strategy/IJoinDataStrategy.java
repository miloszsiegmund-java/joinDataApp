package com.example.joinDataApp.strategy;

public interface IJoinDataStrategy<T> {
    T joinData(T firstValue, T secondValue);
}