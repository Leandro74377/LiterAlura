package com.literalura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LiterAlura {

    public static void main(String[] args) {
        Database.createTable(); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Bienvenido a LiterAlura ===");
            System.out.println("1. Buscar libros por título");
            System.out.println("2. Ver todos los libros guardados");
            System.out.println("3. Buscar libros por autor");
            System.out.println("4. Contar cuántos libros tienes guardados");
            System.out.println("5. Salir");

            System.out.print("Elige una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Introduce el título o palabra clave: ");
                    String query = scanner.nextLine();
                    String response = BookAPI.getBooks(query);
                    if (response != null) {
                        saveBooksFromResponse(response); 
                        BookParser.parseBooks(response); 
                    } else {
                        System.out.println("Error al obtener los libros de la API.");
                    }
                    break;

                case 2:
                    viewAllBooks(); 
                    break;

                case 3:
                    System.out.print("Introduce el nombre del autor: ");
                    String authorQuery = scanner.nextLine();
                    viewBooksByAuthor(authorQuery);
                    break;

                case 4:
                    countBooks();
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    return;

                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
    }

   
    private static void saveBooksFromResponse(String jsonResponse) {
        try {
            com.google.gson.Gson gson = new com.google.gson.Gson();
            com.google.gson.JsonObject jsonObject = gson.fromJson(jsonResponse, com.google.gson.JsonObject.class);
            com.google.gson.JsonArray items = jsonObject.getAsJsonArray("items");

            for (int i = 0; i < items.size(); i++) {
                com.google.gson.JsonObject item = items.get(i).getAsJsonObject();
                com.google.gson.JsonObject volumeInfo = item.getAsJsonObject("volumeInfo");

                String title = volumeInfo.get("title").getAsString();
                String author = volumeInfo.has("authors") ? volumeInfo.getAsJsonArray("authors").get(0).getAsString() : "Unknown Author";

                Database.insertBook(title, author); 
            }
        } catch (Exception e) {
            System.out.println("Error al guardar los libros en la base de datos.");
            e.printStackTrace();
        }
    }

   
    private static void viewAllBooks() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:books.db")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            System.out.println("\n--- Libros Guardados ---");
            while (rs.next()) {
                System.out.println("Título: " + rs.getString("title"));
                System.out.println("Autor: " + rs.getString("author"));
                System.out.println("-------------");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar la base de datos.");
            e.printStackTrace();
        }
    }

    
    private static void viewBooksByAuthor(String authorName) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:books.db")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '%" + authorName + "%'");
            System.out.println("\n--- Libros de " + authorName + " ---");
            boolean found = false;
            while (rs.next()) {
                System.out.println("Título: " + rs.getString("title"));
                System.out.println("Autor: " + rs.getString("author"));
                System.out.println("-------------");
                found = true;
            }
            if (!found) {
                System.out.println("No se encontraron libros de ese autor.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar la base de datos.");
            e.printStackTrace();
        }
    }


    private static void countBooks() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:books.db")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM books");
            if (rs.next()) {
                System.out.println("Tienes " + rs.getInt("total") + " libros guardados.");
            }
        } catch (Exception e) {
            System.out.println("Error al contar los libros en la base de datos.");
            e.printStackTrace();
        }
    }
}
