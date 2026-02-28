package com.practice.leet

fun isPalindrome(x: Int): Boolean {
    val xStr = x.toString()
    val size = xStr.length
    val arrayChar = xStr.toCharArray()
    for (i in arrayChar.indices) {
        if (arrayChar[i] != arrayChar[size - i - 1]) {
            return false
        }
    }
    return true
}

fun isPalindrome2(x: Int): Boolean {
    val xString = x.toString()
    return xString.reversed() == x.toString()
}

fun main() {
    println(isPalindrome(1121))
}