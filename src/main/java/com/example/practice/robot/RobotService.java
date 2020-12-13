package com.example.practice.robot;

import org.springframework.stereotype.Service;

@Service
public class RobotService {

    public Robot createRobot(final Robot robot) {
        return robot;
    }

    public Robot findById(final Long id) {
        // TODO :: id로 조회

        Robot robot = Robot.builder()
                .id(id)
                .name("RobotV")
                .age(325)
                .build();

        return robot;
    }
}
