package com.leetcode.question;

import java.util.Scanner;

/**
 * Palindrome Number
 */
public class LeetCode9 {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("===============================================");
            System.out.println("请输入数字：");
            int num = scanner.nextInt();

            if (num == 0){
                break;
            }
            System.out.println("翻转后的数值为：" + isPalindrome(num));
        }
        scanner.close();
    }

    private static boolean isPalindrome(int x){

        return true;
    }

}
