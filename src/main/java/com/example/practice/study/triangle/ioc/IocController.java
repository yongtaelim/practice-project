package com.example.practice.study.triangle.ioc;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class IocController {
//    @Autowired
    private IocService iocService;

//    @Autowired
//    public IocController(IocService iocService) {
//        iocService = iocService;
//    }

    public void setService(IocService iocService) {
        this.iocService = iocService;
    }

    public void run() {
        iocService.run();
    }
}
