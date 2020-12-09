package com.example.practice.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
