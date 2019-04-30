package com.mirana.enum_test;


public class MyEnumTest {

    public static void main(String[] args) {
        System.out.println(Color.BLACK);
        System.out.println(Color.BLACK.getColorStr());
        System.out.println("========================");

        Fontxx fontInstance = new Fontxx();
        // ====1、枚举传值
        // 通过枚举设置字体颜色，这里的类型必须是Color枚举，不能传入其他值
        fontInstance.setFontColorByEnum(Color.BLUE);
        // 如果Color没有定义GREEN这个枚举，则不能使用，也不能像setFontColorByConst那样传入字符串
//        fontInstance.setFontColorByEnum(Color.GREEN);
//        fontInstance.setFontColorByEnum("#123456");

        // ====2、常量传值ColorImpl实现了IColor
        // 通过常量设置字体颜色1，ColorImpl.Red 与 IColor.Red一致
        fontInstance.setFontColorByConst(IColor.Red);
        fontInstance.setFontColorByConst(ColorImpl.Red);

        // 通过常量设置字体颜色2，ColorImpl.Blue本身应该与IColor.Blue一致，但是无法保证其他人的ColorImpl中没有重写Blue
        fontInstance.setFontColorByConst(IColor.Blue);
        fontInstance.setFontColorByConst(ColorImpl.Blue);

        // 这里参数是String，不能保证开发人员肯定传入的就是IColor.Blue这样的形参，有可能自定义传入数据
        fontInstance.setFontColorByConst("#123456");
    }
}
