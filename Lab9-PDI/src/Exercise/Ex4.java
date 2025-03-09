package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.*;
import java.util.*;

class Student {
    String name;
    String id;
    String major;

    public Student(String name, String id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

    @Override
    public String toString() {
        return name + "," + id + "," + major;
    }
}

public class Ex4 {
    public static void main(String[] args) {
        String filename = "StudentData.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    students.add(new Student(data[0].replace("Name", ""), data[1].replace("ID: ", ""), data[2].replace("Major: ", "")));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        students.add(new Student("Davin", "004", "SE"));
        students.add(new Student("Rith", "005", "SE"));
        
        students.sort(Comparator.comparing(s -> s.name.trim(), String.CASE_INSENSITIVE_ORDER));
        System.out.println("Sorted Student List:");

        try (FileWriter fw = new FileWriter(filename, true)) { 
            for (Student s : students) {
                fw.write("Name: " + s.name + "\n");
                fw.write("ID: " + s.id + "\n");
                fw.write("Major: " + s.major + "\n");
            }
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }

        System.out.println("File updated successfully.");
    }
}

