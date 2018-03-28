package com.leetcode.question;

import java.util.Scanner;

/**
 * Reverse Integer
 *
 */
public class LeetCode7 {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Integer max--->" + Integer.MAX_VALUE);
        while (true){
            System.out.println("===============================================");
            System.out.println("请输入数字：");
            int num = scanner.nextInt();

            if (num == 0){
                break;
            }
            System.out.println("翻转后的数值为：" + reverse(num));
        }
        scanner.close();
    }

    public static int reverse(int x) {
        int value = Math.abs(x);
        long target = 0;
        while (value/10 != 0){
            target = target*10 + value%10;
            value /= 10;
        }

        target = target*10 + value;

        if (x < 0){
            target = -target;
        }

        if (target > Integer.MAX_VALUE || target < Integer.MIN_VALUE){
            target = 0;
        }
        return (int) target;
    }

}
