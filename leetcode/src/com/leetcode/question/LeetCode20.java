package com.leetcode.question;

import java.util.Stack;
import java.util.regex.Pattern;

public class LeetCode20 {

    public static void main(String... args){
        String[] s = {"()","()[]{}","(]","([)]","{[]}"};

//        for (int i = 0;i < s.length;i++){
//            System.out.println(Pattern.matches(reglex,s[i]));
//        }
        for (int i = 0;i < s.length;i++){
            System.out.println(isValid(s[i]));
        }

        System.out.println("------------------------");

        for (int i = 0;i < s.length;i++){
            System.out.println(isValid1(s[i]));
        }

        System.out.println("------------------------");

        for (int i = 0;i < s.length;i++){
            System.out.println(isValid2(s[i]));
        }
    }

    private static boolean isValid(String s) {
        if (s == null || "".equals(s)){
            return true;
        }

        String replace1 = "()";
        String replace2 = "{}";
        String replace3 = "[]";
        while (s.contains(replace1)  || s.contains(replace2) || s.contains(replace3)){
            if (s.contains(replace1)){
                s = s.replace(replace1,"");
            }
            if (s.contains(replace2)){
                s = s.replace(replace2,"");
            }
            if (s.contains(replace3)){
                s = s.replace(replace3,"");
            }
        }

        return s.equals("");
    }

    private static boolean isValid1(String s) {
        String reglex = "\\{\\}|\\(\\)|\\[\\]";
        if (s == null || "".equals(s)){
            return true;
        }

        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            String topStr = stack.size() == 0?"":stack.peek();
            if (Pattern.matches(reglex,topStr+chars[i])){
                stack.pop();
            }else {
                stack.push(String.valueOf(chars[i]));
            }
        }

        return stack.size() == 0;
    }

    private static boolean isValid2(String s) {
        if (s == null || "".equals(s)){
            return true;
        }

        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            String topStr = stack.size() == 0?"":stack.peek();
            if (isMatch(topStr+chars[i])){
                stack.pop();
            }else {
                stack.push(String.valueOf(chars[i]));
            }
        }

        return stack.size() == 0;
    }

    private static boolean isMatch(String content){
        return content.equals("()") || content.equals("[]") || content.equals("{}");
    }
}
