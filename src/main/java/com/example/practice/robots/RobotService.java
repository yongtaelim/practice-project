package com.example.practice.robots;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RobotService {
    private final RobotRepository robotRepository;

    public Robot createRobot(final Robot robot) {
        return robotRepository.save(robot);
    }

    public Optional<Robot> queryRobot(final Integer id) {
        return robotRepository.findById(id);
    }

    public Robot updateRobot(Robot robot) {
        return robot;
    }
}
