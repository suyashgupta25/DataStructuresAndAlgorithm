package com.practice.leet

import java.lang.Integer.max

fun characterReplacement(s: String, k: Int): Int {
    val freqs = mutableMapOf<Char, Int>()
    var highestFreq = 0
    var maxLen = 0
    var left = 0
    var right = 0

    while(right < s.length) {
        val char = s[right]
        freqs[char] = (freqs[char] ?: 0) + 1
        highestFreq = max(highestFreq, (freqs[char] ?: 0))
        val numCharsToReplace = (right - left + 1) - highestFreq

        if(numCharsToReplace > k) {
            freqs[s[left]] = freqs[s[left]]!! - 1
            left++
        }
        maxLen = right - left + 1

        right++
    }
    return maxLen
}

fun main() {
    println(characterReplacement("ABAB", 2))
}