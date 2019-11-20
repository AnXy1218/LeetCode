package com.leetcode.question;

import java.util.Scanner;

/**
 *  Regular Expression Matching(正则表达式)
 */
public class LeetCode10 {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("===============================================");
            System.out.println("请输入字符串：");
            String content = scanner.nextLine();

            if (content.equals("end")){
                break;
            }

            System.out.println("请输入匹配字符串：");
            String pattern = scanner.nextLine();

            System.out.println("匹配结果：" + isMatch(content,pattern));

        }

        scanner.close();
    }

    /**
     * 是否匹配
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || s.equals("")){
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int sIndex = 0;
        for (int i = 0;i < pArr.length;i++){
              char curr = pArr[i];
              if (curr == '*'){
                  while (sIndex < sArr.length-2 && sArr[sIndex] == sArr[sIndex+1]){
                      sIndex++;
                  }
              }else if (curr == '.'){
                  //一个.对应一个字符
                  if (sIndex < sArr.length-1){
                      sIndex++;
                      continue;
                  }
              }else{
                  //字符匹配必须一致
                  if (curr == sArr[sIndex]){
                      if (sIndex < sArr.length-1){
                          sIndex++;
                          continue;
                      }
                  }else{
                      return false;
                  }
              }
        }

        return true;
    }
}
