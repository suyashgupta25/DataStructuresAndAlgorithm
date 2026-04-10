package com.practice.leet

fun findAnagrams(s: String, p: String): List<Int> {
    val indexes = mutableListOf<Int>()
    val array = p.toCharArray()
    val pValueArray = IntArray(26)
    val windowFreqs = IntArray(26)
    for(c in array) {
        pValueArray[c - 'a']++
    }

    var left = 0
    var right = 0
    while(right < s.length) {
        // Add the character at the right pointer to 'window_freqs'
        // before sliding the window.
        windowFreqs[s[right] - 'a']++
        // If the window has reached the expected fixed length, we
        // advance the left pointer as well as the right pointer to
        // slide the window.
        if((right - left + 1) == p.length) {
            if (windowFreqs.contentEquals(pValueArray)) {
                indexes.add(left)
            }
            // Remove the character at the left pointer from
            // 'window_freqs' before advancing the left pointer.
            windowFreqs[s[left] - 'a']--
            left++
        }
        right++
    }

    return indexes
}

fun findAnagrams2(s: String, p: String): List<Int> {
    val indexes = mutableListOf<Int>()
    var left = 0
    var right = p.length
    val sorted = p.toCharArray().sorted()
    while(right <= s.length) {
        val subArray = s.substring(left, right).toCharArray().sorted()
            if(subArray == sorted) {
                indexes.add(left)
        }
        left += 1
        right += 1
    }

    return indexes
}

fun main() {
    println(findAnagrams("caabab","aba"))
}