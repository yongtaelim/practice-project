package com.example.practice.robots;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/api/robots", produces = MediaTypes.HAL_JSON_VALUE)
@RequiredArgsConstructor
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
        entityModel.add(linkTo(RobotController.class).withRel("update-robot"));
        entityModel.add(linkTo(RobotController.class).slash(newRobot.getId()).withRel("detail"));

        return ResponseEntity.created(uri).body(entityModel);
    }

    @PutMapping
    public ResponseEntity updateRobot(@RequestBody Robot robot) {
        Robot updateRobot = robotService.updateRobot(robot);

        // HAL
        EntityModel<Robot> entityModel = EntityModel.of(updateRobot);
        entityModel.add(linkTo(RobotController.class).withSelfRel());
        entityModel.add(linkTo(RobotController.class).withRel("create-robot"));
        entityModel.add(linkTo(RobotController.class).slash(updateRobot.getId()).withRel("detail"));

        return ResponseEntity.ok(entityModel);
    }

    @GetMapping(value = "/{robotId}")
    public ResponseEntity queryRobot(@PathVariable(value = "robotId") final Integer robotId) throws NotFoundException {
        Optional<Robot> optionalRobot = robotService.queryRobot(robotId);
        if(!optionalRobot.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        // HAL
        EntityModel<Robot> entityModel = EntityModel.of(optionalRobot.get());
        entityModel.add(linkTo(RobotController.class).slash(robotId).withSelfRel());
        entityModel.add(linkTo(RobotController.class).withRel("create-robot"));
        entityModel.add(linkTo(RobotController.class).withRel("update-robot"));
        return ResponseEntity.ok(entityModel);
    }
}
