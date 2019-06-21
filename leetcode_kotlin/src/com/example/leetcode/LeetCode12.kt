package com.example.leetcode

import java.util.*

//val 表示不可变变量
//var 可变变量
//kotlin中when语句代替java中switch
fun main(args:Array<String>){
    val scanner: Scanner = Scanner(System.`in`);
    while (true){
        println("请输入要转化数字:")
        val a = scanner.nextInt()
        if (a == 0){
            break
        }
        println(intToRoman(a))
    }
    scanner.close()

}

fun intToRoman(num:Int):String?{

    var result:String?=""
    var value:Int = num
    if (value/1000>0){
        result += changeNum(value/1000,4)
        value %= 1000
    }

    if (value/100>0){
        result += changeNum(value/100,3)
        value %= 100
    }

    if (value/10>0){
        result += changeNum(value/10,2)
        value %= 10
    }

    if (value >0){
        result += changeNum(value,1)
    }

    return result
}

//1 I
//2 II
//3 III
//4 IV
//5 V
//6 VI
//7 VII
//8 VIII
//9 IX
//10 X

fun changeNum(num:Int,postion:Int):String?{
    var result:String?=""
    var value1:String?=""
    var value5:String?=""
    var value10:String?=""
    if (postion == 1){
        value1 = "I"
        value5 = "V"
        value10 = "X"
    }else if (postion == 2){
        value1 = "X"
        value5 = "L"
        value10 = "C"
    }else if (postion == 3){
        value1 = "C"
        value5 = "D"
        value10 = "M"
    }else if (postion == 4){
        value1 = "M"
        value5 = null.toString()
        value10 = null.toString()
    }

    when(num){
        1-> result= value1
        2-> result = value1+value1
        3-> result = value1+value1+value1
        4-> result = value1+value5
        5-> result = value5
        6-> result = value5+value1
        7-> result = value5+value1+value1
        8-> result = value5+value1+value1+value1
        9-> result = value1+value10
    }

    return result
}