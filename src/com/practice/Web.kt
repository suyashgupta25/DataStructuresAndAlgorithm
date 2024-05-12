package com.practice;

import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL

class Web {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            try {
                val url = URL("https://jsonplaceholder.typicode.com/todos/1")
                val reader = InputStreamReader(url.openStream())
                val dto: TodoDto = Gson().fromJson(reader, TodoDto::class.java)

                println(dto.title)
                println(dto.id)
                println(dto.userId)
                println(dto.completed)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        data class TodoDto(
            val id: Int,
            val userId: Int,
            val title: String,
            val completed: Boolean
        )
    }
}
