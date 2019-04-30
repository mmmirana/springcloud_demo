package com.mirana.enum_test;

public class Fontxx {
    public void setFontColorByEnum(Color colorEnum) {
        System.out.println("setFontColorByEnum: " + colorEnum.getColorStr());
    }

    public void setFontColorByConst(String colorConst) {
        System.out.println("setFontColorByConst: " + colorConst);
    }
}
