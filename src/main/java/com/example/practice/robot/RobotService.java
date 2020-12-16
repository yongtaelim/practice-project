package com.example.practice.robot;

import javassist.NotFoundException;
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

    public Robot findById(final Long id) throws NotFoundException {
        Optional<Robot> optionalRobot = robotRepository.findById(id);
        optionalRobot.orElseThrow(() -> new NotFoundException("id" + id));
        return optionalRobot.get();
    }

    public Robot updateRobot(Robot robot) {
        return robot;
    }
}
