package com.practice.array

class ArrayPrint {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val n = readLine()!!.trim().toInt()

            val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

//            val a = arrayOf(15, 9, 8, 7, 6, 5, 4, 3, 2, 1)
            println()
            a.forEach {
                println(it)
            }
        }

    }
}