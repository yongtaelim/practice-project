package com.example.practice.robots;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RobotTest {

    @Test
    public void builderTest() {
        Robot robot = Robot.builder().build();
        assertThat(robot).isNotNull();
    }
}