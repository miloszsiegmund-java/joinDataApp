package com.example.joinDataApp.number.controller;

import com.example.joinDataApp.number.service.NumberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/number/sum")
public class NumberController {

    private final NumberService numberServiceImpl;

    @ApiOperation(value = "Get sum of two value, first from api and second from random generate")
    @GetMapping
    public Integer getNumber() {
        return numberServiceImpl.sum();
    }
}
