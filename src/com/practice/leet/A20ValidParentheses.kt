package com.practice.leet


fun isValid(s: String): Boolean {
    val chars = s.toCharArray()
    val stack = ArrayDeque<Char>()

    for(char in chars) {
        if(char == '{' || char == '[' || char == '(') {
            stack.addLast(char)
        } else {
            val lastOrNull = stack.lastOrNull()
            if(char == '}' && lastOrNull != '{') {
                return false
            } else if(char == ']' && lastOrNull != '[') {
                return false
            } else if(char == ')' && lastOrNull != '(') {
                return false
            } else {
                stack.removeLast()
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValid("([])"))
}