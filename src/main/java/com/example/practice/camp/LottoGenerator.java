package com.example.practice.camp;

import java.util.*;

public class LottoGenerator {
    private static final int LOTTO_TICKET_LIMIT_NUM = 6;

    private final LottoNumberCollection collection;

    public LottoGenerator(LottoNumberCollection collection) {
        this.collection = collection;
    }

    public List<Integer> generateLotto() {
        Set<Integer> ticket = new HashSet<>();
        List<Integer> lottoNumbers = collection.createNumber();
        shuffleNum(lottoNumbers);
        for (int i = 0; ticket.size() < LOTTO_TICKET_LIMIT_NUM; i++) {
             ticket.add(lottoNumbers.get(i));
        }
        return new ArrayList<>(ticket);
    }

    private void shuffleNum(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }
}
