package com.practice.leet
import java.util.Stack

fun replaceElements(arr: IntArray): IntArray {
    if(arr.size <= 1) return intArrayOf(-1)
    val stack2 = Stack<Int>()
    var right = arr.size - 1
    val stack = ArrayDeque<Int>()
    val list = MutableList(arr.size) { 0 }

    while(right >= 0) {
        val number = arr[right]

        // Remove elements smaller than or equal to current
        while(stack.isNotEmpty() && stack.last() <= number) {
            stack.removeLast()
        }

        // If stack is empty, no greater element exists
        list[right] = if (stack.isEmpty()) -1 else stack.last()

        // Push current element to stack
        stack.addLast(arr[right])

        right--
    }

    return list.toIntArray()
}

fun replaceElements2(arr: IntArray): IntArray {
    if(arr.size <= 1) return arr
    val res = ArrayDeque<Int>()

    for(num in arr) {
        res.addLast(num)
    }
    var maxInt = 0
    val numbers = mutableListOf<Int>()
    for(flag in res) {
        if(maxInt == 0) {
            numbers.add(-1)
            maxInt = flag
        }
        if(flag > maxInt) {
            maxInt = flag
            numbers.add(maxInt)
        } else {
//            numbers.add(-1)
        }
    }
    return numbers.asReversed().toIntArray()
}

fun main() {
    println(replaceElements(intArrayOf(5,2,4,6,1)).contentToString())
}