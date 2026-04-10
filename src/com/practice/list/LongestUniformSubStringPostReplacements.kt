package com.practice.list

import kotlin.math.max

fun characterReplacement(s: String, k: Int): Int {
    var left = 0
    var right = 0
    var maxLenLongest = 0

    // Using a Set gives us O(1) lookups and removals
    val charSet = mutableSetOf<Char>()

    while (right < s.length) {
        val charRight = s[right]

        if (charSet.contains(charRight)) {
            // Remove the leftmost character and shrink the window
            charSet.remove(s[left])
            left++
        } else {
            // Add the new character, calculate max, and expand the window
            charSet.add(charRight)
            maxLenLongest = maxOf(maxLenLongest, charSet.size)
            right++
        }
    }
    return maxLenLongest
}

fun main() {
    val count = characterReplacement("aabcdcca", 2)
    println(count)
}