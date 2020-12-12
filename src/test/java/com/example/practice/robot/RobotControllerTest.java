package com.example.practice.robot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RobotControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createRobot_Success_Test() {
        //given
        Robot robot = Robot.builder()
                .build();

        //when


        //then
    }
}