package com.practice.leet



fun lengthOfLongestSubstring(s: String): Int {
    if(s.isEmpty()) return 0
    if(s.length == 1) return 1

    var map = mutableMapOf<Char, Int>()
    var maxCount = 0
    var localCount = 0
    var left = 0
    var right = 0

    while(right < s.length) {
        val chRight = s[right]
        val rightValue = map[chRight] ?: 0
        map[chRight] = rightValue + 1

        if((map[chRight] ?: 0) > 1) {
            left++
            right = left
            localCount = 1
            map = mutableMapOf()
            val chLeft = s[left]
            val leftValue = map[chLeft] ?: 0
            map[chLeft] = leftValue + 1
        } else {
            localCount++
        }
        if(localCount > maxCount) {
            maxCount = localCount
        }
        right++
    }

    return maxCount
}

fun lengthOfLongestSubstring2(s: String): Int {
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
    println(lengthOfLongestSubstring("bbbb"))
}