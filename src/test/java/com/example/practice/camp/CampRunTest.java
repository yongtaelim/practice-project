package com.example.practice.camp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import static org.assertj.core.api.Assertions.assertThat;


class CampRunTest {

    Camp camp;

    @BeforeAll
    void setUp() {
        camp = new Camp();
    }

    @TestFactory
    @DisplayName("단계별 시나리오 테스트")
    void test() {
        String status = "wait";

        DynamicTest.dynamicTest("1. 캠프에 간다.", () -> {
            String run = camp.run(status);
            assertThat(run).isEqualTo("run");
        });
        DynamicTest.dynamicTest("2. 캠프에서 논다.", () -> {
            String play = camp.play(status);
            assertThat(play).isEqualTo("play");
        });
        DynamicTest.dynamicTest("3. 캠프에서 돌아온다.", () -> {
            String back = camp.back(status);
            assertThat(back).isEqualTo("back");
        });
    }

}
