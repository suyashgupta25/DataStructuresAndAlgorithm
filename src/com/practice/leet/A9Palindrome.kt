package com.practice.leet

fun isPalindrome(x: Int): Boolean {
    val xStr = x.toString()
    return checkPalindrome2(xStr)
}

fun checkPalindrome(x: String): Boolean {
    val size = x.length
    val arrayChar = x.toCharArray()
    for (i in arrayChar.indices) {
        if (arrayChar[i] != arrayChar[size - i - 1]) {
            return false
        }
    }
    return true
}

fun checkPalindrome2(x: String): Boolean {
    val size = x.length
    val arrayChar = x.toCharArray()
    var left = 0
    var right = size - 1
    while (left < right) {
        if(!arrayChar[left].isLetter()) {
            left++
            continue
        }
        if(!arrayChar[right].isLetter()) {
            right--
            continue
        }
        if (arrayChar[left] != arrayChar[right]) {
            return false
        }
        left++
        right--
    }
    return true
}

fun isPalindrome2(x: Int): Boolean {
    val xString = x.toString()
    return xString.reversed() == x.toString()
}

fun main() {
//    println(isPalindrome(1121))
    println(checkPalindrome2("a dog! a  panic in a pagoda."))
}