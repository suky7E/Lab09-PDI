package Exercise;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Employee {
    int id;
    String name;
    int age;
    String email;
    double salary;

    public Employee(int id, String name, int age, String email, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + email + "," + salary;
    }
}

public class Ex5 {
    public static void main(String[] args) {
        String inputFile = "data.csv";

        String errorFile = "error_log.txt";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter errorWriter = new FileWriter(errorFile)) {

            String line;
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length != 5) {
                    errorWriter.write("Malformed row: " + line + "\n");
                    continue;
                }

                try {
                    int id = Integer.parseInt(values[0].trim());
                    String name = values[1].trim();
                    int age = Integer.parseInt(values[2].trim());
                    String email = values[3].trim();
                    double salary = parseSalary(values[4].trim());

                    if (age < 0) {
                        errorWriter.write("Invalid age for ID " + id + "\n");
                        continue;
                    }
                    if (!isValidEmail(email)) {
                        errorWriter.write("Invalid email for ID " + id + "\n");
                        continue;
                    }
                    if (Double.isNaN(salary)) {
                        errorWriter.write("Invalid salary for ID " + id + "\n");
                        continue;
                    }

                    employees.add(new Employee(id, name, age, email, salary));
                } catch (Exception e) {
                    errorWriter.write("Data format error: " + line + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        System.out.println("Validation complete. Check 'error_log.txt' for issues.");
    }

    private static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static double parseSalary(String salaryStr) {
        try {
            return Double.parseDouble(salaryStr);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}

