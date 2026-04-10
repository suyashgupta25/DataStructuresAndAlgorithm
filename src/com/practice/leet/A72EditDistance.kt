package com.practice.leet

fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    // dp[i][j] will be the minimum number of operations to convert
    // word1.substring(0, i) to word2.substring(0, j)
    val dp = Array(m + 1) {
        IntArray(n + 1)
    }

    // Base cases
    for (i in 0..m) {
        dp[i][0] = i
    }
    for (j in 0..n) {
        dp[0][j] = j
    }

    // Fill the DP table
    for (i in 1..m) {
        for (j in 1..n) {
            if (word1[i - 1] == word2[j - 1]) {
                // Characters match, no new operation needed
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                // Characters differ, take the min of insert, delete, or replace + 1
                dp[i][j] = 1 + minOf(
                    dp[i - 1][j],    // Delete from word1
                    dp[i][j - 1],    // Insert into word1
                    dp[i - 1][j - 1] // Replace in word1
                )
            }
        }
    }

    return dp[m][n]
}

fun main() {
    println(minDistance("horse","ros"))
}