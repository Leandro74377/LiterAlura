package com.literalura;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class BookParser {
    public static void parseBooks(String jsonResponse) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
        JsonArray items = jsonObject.getAsJsonArray("items");

        for (int i = 0; i < items.size(); i++) {
            JsonObject item = items.get(i).getAsJsonObject();
            JsonObject volumeInfo = item.getAsJsonObject("volumeInfo");

            String title = volumeInfo.get("title").getAsString();
            String author = volumeInfo.has("authors") ? volumeInfo.getAsJsonArray("authors").get(0).getAsString() : "Unknown Author";

            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("-------------");
        }
    }
}
