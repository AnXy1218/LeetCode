package com.example.leetcode

import java.util.*

//val 表示不可变变量
//var 可变变量
//kotlin中when语句代替java中switch
fun main(args:Array<String>){
    val scanner: Scanner = Scanner(System.`in`);
    while (true){
        println("请输入要转化罗马数字:")
        val a = scanner.next()
        if (a.equals("end")){
            break
        }
        println(romanToInt(a))
    }
    scanner.close()

}

//IV  4
//IX  9
//XL  40
//XC  90
//CD  400
//CM  900

fun romanToInt(romanStr:String):Int{
    var result:Int = 0

    val romanMap = mapOf<String,Int>(
            "I" to 1,"V" to 5,"IV" to 4,"IX" to 9,
            "X" to 10,"L" to 50, "XL" to 40,"XC" to 90,
            "C" to 100,"D" to 500,"CD" to 400,"CM" to 900,
            "M" to 1000)
    var nearIndex:Int = -2
    loop@ for (i in 0 until romanStr.length){
        var subStr:String? = ""
        if (i == nearIndex+1){
            continue@loop
        }
        if (i < romanStr.length-1){
            subStr = romanStr.substring(i,i+2)
            when(subStr){
                "IV","IX","XL","XC","CD","CM"->{
                    result+=romanMap.get(subStr)?:0
                    nearIndex = i

                    continue@loop
                }
            }
        }
        subStr = romanStr.substring(i,i+1)
        result+=romanMap.get(subStr)?:0
    }
    return result
}