package com.mirana.enum_test;

public enum Color {

    RED("#0000ff"),
    BLUE("#00ff00"),
    BLACK("#ff0000");

    private String colorStr;

    private Color(String colorstr) {
        this.colorStr = colorstr;
    }

    public String getColorStr() {
        return colorStr;
    }

    public void setColorStr(String colorStr) {
        this.colorStr = colorStr;
    }
}

