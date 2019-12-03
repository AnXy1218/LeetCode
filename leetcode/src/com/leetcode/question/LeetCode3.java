package com.leetcode.question;

public class LeetCode3 {

    public static void main(String... args){
        int leng = lengthOfLongestSubstring("bbbb");
//        int leng = lengthOfLongestSubstring("au");
        System.out.println(leng);
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int index = 0;
        String subStrLongest = "";
        while (index+length < s.length()){
            int tempLen = length;
            tempLen++;
            String subStr = s.substring(index,index+tempLen);
            sign:
            for (int i = 0;i < subStr.length()-1;i++){
                for (int j = i+1;j < subStr.length();j++){
                    if (subStr.charAt(i) == subStr.charAt(j)){
                        tempLen = -1;
                        break sign;
                    }
                }
            }
            if (tempLen > length){
//                System.out.println(subStr);
                subStrLongest = subStr;
                length = tempLen;
            }else {
                //当length没改变，就改变index
                index++;
            }
        }
        return length;
    }
}
