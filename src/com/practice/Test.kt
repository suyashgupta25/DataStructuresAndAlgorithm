package com.practice

class Test {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(bracketMatcher("(coder)(byte))"))

        }
    }
}

fun bracketMatcher(str: String): String {
    val queue = ArrayDeque<String>()

    for(char in str) {
        if(char == '(') {
            queue.add(char.toString())
        } else if(char == ')') {
            queue.removeLastOrNull() ?: return "0"
        }
    }

    return if(queue.isEmpty()) {
        "1"
    } else {
        "0"
    }
}