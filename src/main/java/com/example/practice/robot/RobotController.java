package com.example.practice.robot;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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
        WebMvcLinkBuilder builder = linkTo(RobotController.class);
        URI uri = builder.toUri();

        // HAL
        EntityModel<Robot> entityModel = EntityModel.of(newRobot);
        entityModel.add(linkTo(RobotController.class).withSelfRel());
        entityModel.add(linkTo(RobotController.class).slash(newRobot.getId()).withRel("detail"));
        entityModel.add(Link.of("/animals", IanaLinkRelations.SELF).withRel("animal_info"));

        return ResponseEntity.created(uri).body(entityModel);
    }

    @GetMapping(value = "/{robotId}")
    public ResponseEntity robotDetail(@PathVariable(value = "robotId") final Long robotId) {
        Robot robot = robotService.findById(robotId);

        // HAL
        EntityModel<Robot> entityModel = EntityModel.of(robot);
        entityModel.add(linkTo(RobotController.class).slash(robotId).withSelfRel());
        entityModel.add(linkTo(RobotController.class).withRel("create"));
        entityModel.add(Link.of("/animals", IanaLinkRelations.SELF).withRel("animal_info"));
        return ResponseEntity.ok(entityModel);
    }
}
