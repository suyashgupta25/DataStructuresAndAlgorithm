package com.practice.leet
// [1, 5, 2, 3, 7], target = 6
// [5, 1, 4, 3, -1]
// [-1, 3, 4, 1, 5]
fun twoSum(nums: IntArray, target: Int): IntArray {
    println(nums.contentToString())
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val numberI = nums[i]
        map[target - numberI] = i
    }
    println(map)
    for (i in nums.indices) {
        val numberI = nums[i]
        val diff = target - numberI
        println("numberI=$numberI diff=$diff")
        if(map.containsKey(numberI) && i != map[numberI]) {
            return intArrayOf(i, map[numberI]!!)
        }
    }
//    for (i in nums.indices) {
//        val numberI = nums[i]
//        for (j in i + 1..<nums.size) {
//            val numberJ = nums[j]
//            if (numberI + numberJ == target) {
//                return intArrayOf(i, j)
//            }
//        }
//    }
    return intArrayOf()
}

fun main() {
    println(twoSum(intArrayOf(3,2,4), 6).contentToString())
}

//[2, 7, 11, 15] , tag = 9