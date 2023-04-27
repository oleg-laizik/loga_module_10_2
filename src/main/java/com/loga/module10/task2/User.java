package com.loga.module10.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;

    }

}
class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/task2/file.txt"))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(" ");
                String name = fields[0];
                int age = Integer.parseInt(fields[1]);
                User user = new User(name, age);
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        try (FileWriter writer = new FileWriter("src/main/resources/task2/user.json")) {
            writer.write(json);
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
