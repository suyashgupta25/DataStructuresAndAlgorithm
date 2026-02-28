package com.practice.leet

fun lengthOfLongestSubstring(s: String): Int {
    var longestFinal = ""
    val indices: Int = s.length - 1
    for(i in s.indices) {
        val charsSet = mutableSetOf<Char>()
        var longest = ""
        for (j in i..indices) {
            val jChar = s[j]
            if(!charsSet.contains(jChar)) {
                longest += jChar
                charsSet.add(jChar)
            } else {
                break
            }
        }
        if(longest.length > longestFinal.length) {
            longestFinal = longest
        }
    }
//    println(longestFinal)
    return longestFinal.length
}


fun main() {
    println(lengthOfLongestSubstring("pwwkew"))
}