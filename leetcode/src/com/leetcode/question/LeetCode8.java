package com.leetcode.question;

import java.util.Scanner;

/**
 * Reverse Integer
 *
 */
public class LeetCode8 {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Integer max--->" + Integer.MAX_VALUE);
        while (true){
            System.out.println("===============================================");
            System.out.println("请输入数字：");
            String content = scanner.nextLine();

            if (content.equals("end")){
                break;
            }
            System.out.println("翻转后的数值为：" + myAtoi(content));
        }
        scanner.close();
    }

    public static int myAtoi(String str) {
        if(str == null || str.trim().equals("")){
            return 0;
        }

        long target = 0;
        char[] strChars = str.trim().toCharArray();
        for (int i = 0;i<strChars.length;i++) {
            if (strChars[i] >= '0' && strChars[i] <= '9') {
                target = target * 10 + (strChars[i] - '0');
                //当超过Integer最大值跳出
                if (target > Integer.MAX_VALUE){
                    break;
                }
            }else if (i == 0){
                //当第一位不'='、'-'或者数字，直接返回0
                if(strChars[i] != '+' && strChars[i] != '-'){
                    return 0;
                }
            }else if (i == 1){
                //当第一位是'='、'-'或者数字，第二位不是0-9直接返回0
                if ((strChars[0] == '+' || strChars[0] == '-') &&
                        (strChars[1] < '0' || strChars[1] > '9')){
                    return 0;
                }else{
                    //第二位是非数字，直接跳出
                    break;
                }
            }else{
                //后边是非数字，直接跳出
                break;
            }
        }

        if (strChars[0] == '-') {
            target = -target;
        }

        if (target > Integer.MAX_VALUE){
            target = Integer.MAX_VALUE;
        }

        if (target < Integer.MIN_VALUE){
            target = Integer.MIN_VALUE;
        }
        return (int) target;
    }

}
