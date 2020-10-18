package com.example.joinDataApp.number.controller;

import com.example.joinDataApp.number.service.NumberService;
import com.example.joinDataApp.source.DataSourceType;
import com.example.joinDataApp.strategy.MethodType;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/number")
public class NumberController {

    private final NumberService numberServiceImpl;

    @ApiOperation(value = "Get sum of two value, first from api and second from random generate")
    @GetMapping("/join/{method}/{firstSource}/{secondSource}")
    public Integer getNumber(@ApiParam(value = "Method name", required = true) @PathVariable(name = "method") MethodType methodType,
                             @ApiParam(value = "First data source", required = true) @PathVariable(name = "firstSource") DataSourceType firstSource,
                             @ApiParam(value = "Second data source", required = true) @PathVariable("secondSource") DataSourceType secondSource) {
        return numberServiceImpl.sum(methodType, firstSource, secondSource);
    }

}
