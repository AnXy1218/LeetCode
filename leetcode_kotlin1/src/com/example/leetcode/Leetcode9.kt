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
        println("回文数返回结果：" + isPalindrome(a));
    }
    scanner.close();
}

fun isPalindrome(x:Int):Boolean{
    var x1 = x;
    var target:Int = 0;
    while (x1/10 != 0){
        target = target*10+x1%10;
        x1 = x1/10;
    }
    target = target*10+x1;
    if (x == target){
        return true;
    }
    return false;
}