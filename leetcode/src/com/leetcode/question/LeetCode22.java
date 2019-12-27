package com.leetcode.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 括号生成
 * 方法一：用插入法，""插入为()，并用set去重
 * 方法二：动态规划法
 */
public class LeetCode22 {

    public static void main(String... args){
        System.out.println(generateParenthesis1(1));
    }

    private static List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        if (n == 0){
            return new ArrayList<>(set);
        }

        set.add("");
        for (int k = 0;k < n;k++){
            Set<String> tempSet = new HashSet<>();
            for (String txt:set){
                for(int i = 0;i <= txt.length();i++){
                    String preTxt = txt.substring(0,i);
                    String lastTxt = txt.substring(i);
                    tempSet.add(preTxt+"()" + lastTxt);
                }
            }
            set = tempSet;
        }

        return new ArrayList<>(set);
    }

    private static List<String> generateParenthesis1(int n) {
        List<List<String>> list = new ArrayList<>();
        if (n == 0){
            return new ArrayList<>();
        }

//        list.add();
        for (int i = 1;i <= n;i++){
            List<String> tempList = new ArrayList<>();
            for (int j = 0;j < i;j++){
                List<String> setP = list.get(j);
                List<String> setQ = list.get(i-1-j);
                for (String txtP:setP){
                    for (String txtQ:setQ){
                        tempList.add("(" + txtP + ")" + txtQ);
                    }
                }
            }

            list.add(tempList);
        }

        return list.get(list.size()-1);
    }
}
