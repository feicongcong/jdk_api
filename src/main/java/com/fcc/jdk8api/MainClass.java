//声明包
package com.fcc.jdk8api;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 15:03 2018/11/25
 */
public class MainClass {
    /**
     * 包含main()方法的类为一个java程序的主类
     * 权限修饰符，静态（全局）修饰符，返回修饰符
     * @param args 入参
     */
    public static void main(String[] args){
        //8种数据类型
        //整数型，3种表现形式：十进制、八进制（以0开头0123=83；-0123=-83）、16进制（以0X开头0Xb01e=456086）
        //整形根据所占内存大小不同，分byte、short、int、long
        //byte(8位，-128~127)、
        // short(16位，-32768~32767)、
        // int(32位，)、
        // long(64位，)L
        byte b=124;

        //浮点型(默认为double)F(float不加F会报错)/D，两种：float(单精度浮点型,32位)、double(双精度浮点型，64位)
        float f1=13.1F;
        double d1=120.1D;
        double d2=120.1;

        //ASCII码由一个字节中的7位(bit)表示，范围是0x00 - 0x7F 共128个字符
        //为了把全世界人民所有的所有的文字符号都统一进行编码，于是制定了UNICODE标准字符集,UNICODE 使用2个字节表示一个字符
        //UNICODE 的范围是 0x0000 - 0xFFFF 共6万多个字符,其中汉字占用4万多
        //字符型char(16位，单引号标识，'s',"s"表示字符串)
        char a='a';
        //字符a在码表中值位97，java可以把字符当做整数对待
        char x=97;
        System.out.println(a+1);//98
        System.out.println((char)(a+1));//b
        System.out.println("UNICODE码第23045位："+(char)23045);//UNICODE码第23045位：娅
        //转义字符，以\开头
        /**
         * \ddd:
         * \dxxxx
         * \'
         * \\
         * \r回车
         * \n换行
         * \b退格
         */

        //布尔型

        //标识符（理解为名字），关键字
        //声明变量：为了告诉编译器（compiler）这个变量的数据类型，编译器才能知道需要分配多少空间给他，空间内的值是变化的，所以这个内存空间成为变量
        //声明常量（final变量，为对象所共享）
    }
}
