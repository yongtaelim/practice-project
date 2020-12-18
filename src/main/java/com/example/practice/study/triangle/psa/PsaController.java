package com.example.practice.study.triangle.psa;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PsaController {
    private final PsaService psaService;

    @GetMapping
    public String psaGet() {
        return psaService.run();
    }
}
