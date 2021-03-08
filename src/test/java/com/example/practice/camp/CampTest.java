package com.example.practice.camp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CampTest {
    @Autowired
    static LottoRepository lottoRepository;

    @AfterEach
    static void afterEach() {
        lottoRepository.deleteAll();
    }

    @Test
    void test1() {
        Lotto lotto = Lotto.builder().number(1).name("대박 로또").build();

        lottoRepository.save(lotto);

    }

    @Test
    void test2() {
        Lotto lotto = Lotto.builder().number(2).name("대박 로또").build();

        lottoRepository.save(lotto);
    }

    @Test
    void test3() {
        List<Lotto> allCount = lottoRepository.findAll();
        assertThat(allCount).hasSize(0);
    }
}
