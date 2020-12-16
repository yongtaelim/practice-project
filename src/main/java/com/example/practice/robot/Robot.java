package com.example.practice.robot;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(of = {"id"})
@Entity
public class Robot {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private Integer age;

    @Builder
    public Robot(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
