package com.leetcode.question;

import java.io.Console;
import java.util.Scanner;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 */
public class LeetCode5 {
    public static void main(String... args){

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("===============================================");
            System.out.println("请输入文字：");
            String content = scanner.nextLine();

            if (content.equals("end")){
                break;
            }

            System.out.println("输出：");
            System.out.println(longestPalindrome(content));
        }

        scanner.close();
    }

    /**
     * 这个算法始终报：Time Limit Exceeded
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        String longestStr = s.substring(0,1);

        int index = 0;
        while ((index + longestStr.length()) < s.length()){
            int j = index + longestStr.length();
            while (j < s.length()){
                String sub = s.substring(index,j+1);
                if (isPalindromic(sub)){
                    longestStr = sub;
                }
                j++;
            }
            index++;
        }

        return longestStr;
    }

    /**
     * 判断一个字符串是否是回文串
     * @return
     */
    private static boolean isPalindromic(String s){
        int start = 0,end = s.length() - 1;
        while (start <= end){
            char startChar = s.charAt(start);
            char endChar  = s.charAt(end);
            if (startChar != endChar){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
