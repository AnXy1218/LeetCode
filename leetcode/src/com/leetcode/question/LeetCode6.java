package com.leetcode.question;

import java.util.Scanner;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 之字形
 */
public class LeetCode6 {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("===============================================");
            System.out.println("请输入文字：");
            String content = scanner.nextLine();

            if (content.equals("end")){
                break;
            }

            System.out.println("请输入行数：");
            int rowNums = scanner.nextInt();

            System.out.println("输出：");
            System.out.println(convert(content,rowNums));
        }

        scanner.close();
    }

    private static String convert(String s,int numRows){
//        int n = length/(4*numRows-4) + 1;
//        for (int i = 0;i < n;i++){
//            for (int j=0;j < numRows;j++){
//                String str = new String(new char[]{s.charAt(i*(4*numRows-4)+j),s.charAt(i*(4*numRows-4)+ j + (2*numRows-2))});
//                System.out.println("第" + j + "行" + str);
//            }
//        }

        StringBuffer[] sbs = new StringBuffer[numRows];

        for (int i = 0;i < numRows;i++){
            StringBuffer sb=new StringBuffer();
            sbs[i] = sb;
        }

        if(s.length() <= numRows || numRows == 1){
            return s;
        }

        for (int i = 0;i < s.length();i++){
            int index = i%(2*numRows-2);
            if (index < numRows){
                sbs[index].append(s.charAt(i));
//                System.out.println("第" + index + "行：" + s.charAt(i));
            }else{
                index = index+1-numRows;
                sbs[numRows-index-1].append(s.charAt(i));
//                System.out.println("第" + (numRows-index) + "行：" + s.charAt(i));
            }
        }

        for (int i = 1;i < sbs.length;i++){
//            System.out.println("第" + i + "行：" + sbs[i].toString());
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
