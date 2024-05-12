package com.practice;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;

public class Webservice {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
            InputStreamReader reader = new InputStreamReader(url.openStream());
            TodoDto dto = new Gson().fromJson(reader, TodoDto.class);

            // using the deserialized object
            System.out.println(dto.title);
            System.out.println(dto.id);
            System.out.println(dto.userId);
            System.out.println(dto.completed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class TodoDto {
        int id;
        int userId;
        String title;
        boolean completed;
    }
}
