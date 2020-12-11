package com.example.practice.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AopService {

    @LogExcution
    public String run() {
        log.info("aop service run.");
        return "aop_service_run";
    }
}
