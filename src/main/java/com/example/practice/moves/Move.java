package com.example.practice.moves;

import java.util.EnumSet;

public class Move {
    public static void main(String[] args) {

    //        MoveEnum[] values = MoveEnum.values();
    //        for (MoveEnum value : values) {
    //            System.out.println(value);
    //        }
    //
    //        MoveEnum test1 = MoveEnum.valueOf("TEST1");
    //        System.out.println(test1);

    //        System.out.println(MoveEnum.TEST1.name());
    //
    //        System.out.println(MoveEnum.TEST1.ordinal());
    //        System.out.println(MoveEnum.TEST2.ordinal());
    //
    //        if ( MoveEnum.TEST1.ordinal() == 0) {
    //            System.out.println("0");
    //        }

        EnumSet<MoveEnum> moveEnumsAll = EnumSet.allOf(MoveEnum.class);
        for (MoveEnum moveEnum : moveEnumsAll) {
            System.out.println("allOf : " + moveEnum.name());
        }

        EnumSet<MoveEnum> moveEnums = EnumSet.of(MoveEnum.TEST1, MoveEnum.TEST2);
        for (MoveEnum moveEnum : moveEnums) {
            System.out.println("of : " + moveEnum.name());
        }

        EnumSet<MoveEnum> moveEnumsNone = EnumSet.noneOf(MoveEnum.class);
        for (MoveEnum moveEnum : moveEnumsNone) {
            System.out.println("noneOf : " + moveEnum.name());
        }
    }
}
