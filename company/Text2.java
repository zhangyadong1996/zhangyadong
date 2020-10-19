package com.company;

import java.util.Scanner;

public class Text3 {
    public static void main(String[] args) {
        int price = 5000;//机票价格
        int moth;
        int position;//舱位1 头等舱2、商务舱 3经济 舱

        Scanner input = new Scanner(System.in);
        System.out.println("请输入你的要出行的月份");
        moth = input.nextInt();
        if (moth > 0 && moth < 13) {
            if (moth > 4 && moth < 10) {
                System.out.println("请输入你出行的舱位");
                position = input.nextInt();
                switch (position) {
                    case 1:
                        System.out.println("你选择的是头等舱" + "机票价格为" + price
                                * 0.9);
                        break;
                    case 2:
                        System.out.println("你选择的是商务舱" + price * 0.8);
                        break;
                    case 3:
                        System.out.println("你选择的是经济舱" + price * 0.7);
                        break;
                }
            } else {
                System.out.println("您选择的是淡季");
                System.out.println("请输入你出行的舱位");
                position = input.nextInt();
                switch (position) {
                    case 1:
                        System.out.println("你选择的是头等舱" + "机票价格为" + price
                                * 0.5);
                        break;
                    case 2:
                        System.out.println("你选择的是商务舱" + price * 0.4);
                        break;
                    case 3:
                        System.out.println("你选择的是经济舱" + price * 0.3);
                        break;
            }

        }
    }
}