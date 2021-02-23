package com.example.practice.annotations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Car {
    public void print() {
        System.out.println("Car");
    }


    public void test() throws ClassNotFoundException {
        Integer carCount = null;

        System.out.println(carCount.toString());  // NPE 발생

//        Class clazz = Class.forName("dd");

        try {
            System.out.println("try");
            Class clazz = Class.forName("dd");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("catch ClassNotFoundException");
        } finally {
            System.out.println("finally");
        }

        FileInputStream file = null;
        try {
            file = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (FileInputStream file1 = new FileInputStream("")) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test3() throws Exception {
        test2("");
    }

    public void test2(String data) throws Exception{
        System.out.println(data.indexOf(1));
    }

    public void test4() throws CustomException {
        try {
            FileInputStream fi = new FileInputStream("dddd");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CustomException("Exception을 Custom했다", e);
        }
    }
}