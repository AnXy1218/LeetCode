package com.example.leetcode

import java.util.*

fun main(args:Array<String>){
    val scanner:Scanner = Scanner(System.`in`);
    while (true){
        println("请输入判断数字");
        val a = scanner.nextInt();
        if (a == 0){
            break;
        }
        var height:IntArray;
        height = intArrayOf(54,89,65,74);
        var leetcode11:Leetcode11;
        leetcode11 = Leetcode11();
        println("回文数返回结果：" + leetcode11.maxArea(height));
    }
    scanner.close();
}

class Leetcode11{
    fun maxArea(height:IntArray):Int{
        var area:Int = 0;
        for(i in 0..height.size-2){
            for (j in i+1..height.size-1){
                var temp = (j-i)*Math.min(height[i],height[j]);
                if (temp > area){
                    area = temp;
                }
            }
        }
        return area;
    }
}
