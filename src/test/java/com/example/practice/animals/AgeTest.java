package com.example.practice.animals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AgeTest {

    @Test
    void builder_test() {
        //given
        Animal animal = Animal.builder().build();

        //when then
        assertThat(animal).isNotNull();
    }
}
