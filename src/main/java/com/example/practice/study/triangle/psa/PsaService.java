package com.example.practice.study.triangle.psa;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PsaService {

    @Transactional
    public String run() {
        return "psa";
    }
}
