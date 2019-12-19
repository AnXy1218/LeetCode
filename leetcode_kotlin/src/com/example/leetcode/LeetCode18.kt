package com.example.leetcode

import java.util.*

fun main(args:Array<String>){
    var array = intArrayOf(1, 0, -1, 0, -2, 2)
    var target = 0
    println(fourSum(array,target))
}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    var resultList:MutableList<List<Int>> = mutableListOf()
    Arrays.sort(nums)
    for (i in 0 until nums.size-3){
        for (j in i+1 until nums.size-2){
            var temp = target-nums[i]-nums[j]
            var k = j+1
            var z = nums.size-1
            while (k < z){
                if (nums[k] + nums[z] < temp){
                    k++
                }else if (nums[k] + nums[z] > temp){
                    z--
                }else{
                    val tempArray = intArrayOf(nums[i],nums[j],nums[k],nums[z])
                    var isExist = false
                    if (resultList.size > 0){
                        for (z in 0 until resultList.size){
                            if (resultList[z][0] == tempArray[0]
                                    && resultList[z][1] == tempArray[1]
                                    && resultList[z][2] == tempArray[2]
                                    && resultList[z][3] == tempArray[3] ){
                                isExist =true
                                break
                            }
                        }
                    }

                    if (!isExist){
                        var tempList = listOf(nums[i],nums[j],nums[k],nums[z])
                        resultList.add(tempList)
                    }
                    k++
                    z--
                }
            }
        }
    }

    return resultList
}