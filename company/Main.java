package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            String  xingqi;        // write your code here
        Scanner input=new Scanner(System.in);
        System.out.println("请输入第一个字母");
                xingqi=input.next();
                switch (xingqi){
                    case "M":
                        System.out.println("星期一");
                        break;
                    case "T":
                        System.out.println("请输入第二个单词");
                        xingqi=input.next();
                        if (xingqi.equals("u")){
                            System.out.println("星期二");
                        }else if(xingqi.equals("h")){
                            System.out.println("星期四");
                        }
                        break;
                    case "W":
                        System.out.println("星期三");
                        break;
                    case "F":
                        System.out.println("星期五");
                        break;
                    case "S":
                        System.out.println("请输入第二个字母");
                        xingqi =input.next();
                        if (xingqi.equals("a")){
                            System.out.println("星期6");
                        }else if (xingqi.equals("u")){
                            System.out.println("星期天");
                        }else{
                            System.out.println("输入有误");
                        }
                        break;
                }
    }
}
