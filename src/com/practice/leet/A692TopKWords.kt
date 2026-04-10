package com.practice.leet

import java.util.PriorityQueue

fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val wordCounts = words.groupingBy { it }.eachCount()
    val heap = PriorityQueue<Pair>{ a,b ->
        if(a.count == b.count) {
            a.word.compareTo(b.word)
        } else {
            b.count.compareTo(a.count)
        }
    }
    heap.addAll(wordCounts.map { Pair(it.key, it.value) })

    return List(k) { heap.poll().word }
}

data class Pair(val word: String, val count: Int)

fun main() {
    val words = arrayOf("i","love","leetcode","i","love","coding")
    val k = 2
    println(topKFrequent(words, k).toString())
}