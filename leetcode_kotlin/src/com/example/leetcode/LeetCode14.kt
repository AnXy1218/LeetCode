package com.example.leetcode

import java.util.*

//val 表示不可变变量
//var 可变变量
//kotlin中when语句代替java中switch
fun main(args:Array<String>){
//    val scanner: Scanner = Scanner(System.`in`)
//    while (true){
//        println("请输入要转化罗马数字:")
//        val a = scanner.next()
//        if (a.equals("end")){
//            break
//        }
//        println(romanToInt(a))
//    }
//    scanner.close()
    var array = arrayOf("dog","racecar","car")
    println(longestCommonPrefix(array))
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.size == 0){
        return ""
    }
    var result = ""
    for (j in 1..strs[0].length){
        //找出所有第一个元素所有的字串
        var  temp = strs[0].substring(0,j)
        var isBreak = false
        for (z in 1 until strs.size){
            if (!strs[z].startsWith(temp)){
                isBreak = true
                break
            }
        }
        if (!isBreak){
            if (temp.length > result.length){
                result = temp
            }
        }
    }
//    for (i in 0..strs[0].length){
//        for (j in i+1..strs[0].length){
//            //找出所有第一个元素所有的字串
//            var  temp = strs[0].substring(i,j)
//            var isBreak = false
//            for (z in 1 until strs.size){
//                if (!strs[z].contains(temp)){
//                    isBreak = true
//                    break
//                }
//            }
//            if (!isBreak){
//                if (temp.length > result.length){
//                    result = temp
//                }
//            }
//        }
//    }
    return result
}
