package com.example.leetcode

import java.util.*


//val 表示不可变变量
//var 可变变量
//kotlin中when语句代替java中switch
/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
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
    var target = "23"
//    var array = intArrayOf(1,2,4,8,16,32,64,128)
//    val target:Int = 82
//    for (i in 2..9){
//        println(getNumArray(i))
//    }

    var digits = "23"
//    var charArray = digits.toCharArray()
//    print(charArray[0].toInt())
    println(letterCombinations(digits))
}

fun letterCombinations(digits: String): List<String> {
    var result:MutableList<String> = mutableListOf()
    var charArray = digits.toCharArray()
    for (i in 0 until charArray.size){
        var numArray = getNumArray(charArray[i]-'0')
        var tempList:MutableList<String> = mutableListOf()
        if (result.size == 0){
            for (j in 0 until numArray.size){
                result.add(numArray[j].toString())
            }
            continue
        }
        for (j in 0 until result.size){
            tempList.add(result.get(j))
        }
        result.clear()
        for (j in 0 until numArray.size){
            for (k in 0 until tempList.size) {
                result.add(tempList.get(k) + numArray.get(j))
            }
        }
    }
    return result
}

fun getNumArray(num:Int):CharArray{
    var length = 3
    if (num == 7 || num == 9){
        length = 4
    }
    var charArray = CharArray(length)
    when(num){
        2,3,4,5,6->{
            charArray = charArrayOf('a'+(num-2)*3,'a'+(num-2)*3+1,'a'+(num-2)*3+2)
        }
        7->{
            charArray = charArrayOf('p','q','r','s')
        }
        8->{
            charArray = charArrayOf('t','u','v')
        }
        9->{
            charArray = charArrayOf('w','x','y','z')
        }
    }

    return  charArray
}

