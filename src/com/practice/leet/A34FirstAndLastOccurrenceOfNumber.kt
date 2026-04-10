package com.practice.leet

fun searchRange(nums: IntArray, target: Int): IntArray {
    if(nums.isEmpty()) return intArrayOf()
    if(nums.size == 1 && nums[0] == target) {
        return intArrayOf(0)
    }

    var left = 0
    var right = nums.size
    while (left < right) {
        val mid =  left + (right - left) / 2

        if(nums[mid]  > target) {
            right = mid
        } else if(nums[mid]  < target){
            left = mid + 1
        } else {
            right = mid
        }
    }
    return intArrayOf(left)
}


fun main() {
    val nums = intArrayOf(1,2,4,4,4,5,6,7)
    println(searchRange(nums, target = 3).contentToString())
}