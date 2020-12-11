package com.example.practice.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AopController {

    private final AopService aopService;        // IoC

    @GetMapping(value = "/aop")
    public String aopGet() {
        return aopService.run();
    }
}