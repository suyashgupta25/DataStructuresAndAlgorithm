package com.practice.leet


fun isHappy(n: Int): Boolean {
    var slowPtr = getNextNumber(n)
    var fastPtr = getNextNumber(getNextNumber(n))
//    println("slowPtr=$slowPtr fastPtr=$fastPtr")
    while(fastPtr != slowPtr) {
        slowPtr = getNextNumber(slowPtr)
        fastPtr = getNextNumber(getNextNumber(fastPtr))
//        println("slowPtr=$slowPtr fastPtr=$fastPtr")
    }
    return slowPtr == 1
}

fun getNextNumber(n: Int): Int {
    if(n == 0) {
        return 0
    }
    val rem = n % 10
    val quo = n / 10
//    println("rem=$rem quo=$quo")
    return rem * rem + getNextNumber(quo)
}

fun main() {
    val number = 81
    println(isHappy(number))
}