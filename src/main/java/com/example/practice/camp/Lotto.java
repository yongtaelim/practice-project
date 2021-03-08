package com.example.practice.camp;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class Lotto {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Integer number;

    @Builder
    public Lotto(Integer id, String name, Integer number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
}
