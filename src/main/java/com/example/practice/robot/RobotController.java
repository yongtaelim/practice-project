package com.example.practice.robot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {
    private RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @GetMapping(value = "/robot/create")
    public ResponseEntity createRobot(@RequestBody Robot robot) {
        Robot newRobot = robotService.createRobot(robot);
        return ResponseEntity.created(null).build();
    }

}
