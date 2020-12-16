package com.example.practice.robot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RobotService {
    private final RobotRepository robotRepository;

    public Robot createRobot(final Robot robot) {
        return robotRepository.save(robot);
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

    public Robot updateRobot(Robot robot) {
        return robot;
    }
}
