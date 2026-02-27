package com.practice.dsa

class Fold {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val split = "Kotlin is a powerful language".split(" ")
            val sfd = split.fold("") { acc, value ->
                if(value.length > acc.length) {
                    value
                } else {
                    acc
                }
            }
            println(sfd)
        }
    }
}