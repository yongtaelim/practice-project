package com.example.practice.camp;

import java.util.List;

public class LottoNumberCollection {
    private List<Integer> lottoNumbers;
    private static final int MAX_LOTTO_NUMBER = 31;

    public List<Integer> createNumber() {
        for (int i = 0; i < 31; i++) {
             lottoNumbers.add(i);
        }

        return lottoNumbers;
    }
}
