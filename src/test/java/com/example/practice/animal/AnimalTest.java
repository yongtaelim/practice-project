package com.example.practice.animal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AnimalTest {

    @Test
    void builder_test() {
        //given
        Animal animal = Animal.builder().build();

        //when then
        assertThat(animal).isNotNull();
    }
}
