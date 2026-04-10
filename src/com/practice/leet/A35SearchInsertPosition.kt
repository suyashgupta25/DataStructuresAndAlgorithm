package com.practice.leet

fun searchInsert(nums: IntArray, target: Int): Int {
    if(nums.isEmpty()) return 0
    if(nums.size == 1) {
        return if(target > nums[0]) 1 else 0
    }

    var left = 0
    var right = nums.size
    while(left < right) {
        val mid = left + (right - left)/2
        if(nums[mid] >= target) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

//fun searchInsert2(nums: IntArray, target: Int): Int {
//    if(nums.isEmpty()) return 0
//    if(nums.size == 1) {
//        return if(target > nums[0]) 1 else 0
//    }
//
//    var left = 0
//    var right = nums.size
//    while(left < right) {
//        val mid = left + (right - left)/2
//        if(nums[mid] >= target) {
//            right = mid
//        } else {
//            left = mid + 1
//        }
//    }
//    return left
//}

fun main() {
    val array = intArrayOf(1, 3, 5, 7, 9)
    println(searchInsert(array, 19))
}