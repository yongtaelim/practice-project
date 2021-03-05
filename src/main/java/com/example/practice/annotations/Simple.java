package com.example.practice.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

public class Simple {

    public static void main(String[] args) {
        Annotation[] annotations = SimpleDetailService.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
