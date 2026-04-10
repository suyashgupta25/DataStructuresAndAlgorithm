package com.practice.list

fun findInsertionIndex(numbers: IntArray, target: Int): Int {
    var left = 0
    var right = numbers.lastIndex

    while(left != right) {
        val mid = left + (right - left)/2

        if(numbers[mid] < target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

fun main() {
//    println(findInsertionIndex(intArrayOf(1,2,4,5,7,8,9), target = 6))
    println(findFirstAndLastIndex(intArrayOf(1,2,3,4,4,4,5,6,7,8,9,10,11), target = 4))
}

fun findFirstAndLastIndex(numbers: IntArray, target: Int): Int {
    var left = 0
    var right = numbers.lastIndex

    while(left != right) {
        val mid = left + (right - left)/2
        val mid2 = mid +1

        if(numbers[mid] < target) {
            left = mid + 1
        } else if(numbers[mid] > target) {
            right = mid - 1
        } else {
            right = mid
        }
    }
    println("l=$left r=$right")
    left = 0
    right = numbers.lastIndex
    while(left != right) {
        val mid = left + (right - left)/2 +1

        if(numbers[mid] < target) {
            left = mid + 1
        } else if(numbers[mid] > target)  {
            right = mid - 1
        } else {
            left = mid
        }
    }
    println("l=$left r=$right")
    return left
}
