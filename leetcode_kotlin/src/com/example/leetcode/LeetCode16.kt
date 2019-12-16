package com.example.leetcode

import java.util.*


//val 表示不可变变量
//var 可变变量
//kotlin中when语句代替java中switch
/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
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
    var array = intArrayOf(-1,2,1,-4)
    val target:Int = 1
//    var array = intArrayOf(1,2,4,8,16,32,64,128)
//    val target:Int = 82
    println(threeSumClosest(array,target))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    var result:Int = 0
    if (nums == null || nums.size < 3){
        for (i in 0..nums.size){
            result += nums[i]
        }
        return result
    }

    println("----------->1")

    sort16(nums)

    result=nums[0]+nums[1]+nums[2]

    for (i in 0..nums.size-2){
        for (j in i+1 until nums.size-1){
            for (k in j+1 until nums.size){
                if (nums[i]+nums[j]+nums[k] == target){
                    return target
                }else if (abs(target-nums[i]-nums[j]-nums[k]) < abs(target-result)){
                    result = nums[i]+nums[j]+nums[k]
                }
            }
        }
    }

    return result
}


fun sort16(nums: IntArray){
    for (i in 0 until nums.size){
        for (j in i+1 until nums.size){
            if (nums[i] > nums[j]){
                var temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
            }
        }
    }
}

fun abs(num:Int):Int{
    if (num>=0)
        return num
    else
        return (-num)
}