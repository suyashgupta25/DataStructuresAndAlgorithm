package com.practice.leet

class A1TwoSum {

    // [1, 5, 2, 3, 7], target = 6
    // [5, 1, 4, 3, -1]
    // [-1, 3, 4, 1, 5]
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val index = 1
        for(i in nums.indices) {
            val numberI = nums[i]
            for (j in i + 1..< nums.size) {
                val numberJ = nums[j]
                if(numberI + numberJ == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }
}