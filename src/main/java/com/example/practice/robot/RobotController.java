package com.example.practice.robot;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/robots", produces = MediaTypes.HAL_JSON_VALUE)
public class RobotController {
    private RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping
    public ResponseEntity createRobot(@RequestBody Robot robot) {
        Robot newRobot = robotService.createRobot(robot);
        WebMvcLinkBuilder builder = WebMvcLinkBuilder.linkTo(RobotController.class);
        URI uri = builder.toUri();
        return ResponseEntity.created(uri).body(newRobot);
    }

}
