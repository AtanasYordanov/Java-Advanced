package t01_DefiningClasses.p04_CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee;
            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else {
                if (Character.isDigit(tokens[4].charAt(0))) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            employees.add(employee);
        }
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(kvp -> kvp.getValue().stream().mapToDouble(Employee::getSalary)
                                .average().getAsDouble(), Comparator.reverseOrder()))
                .limit(1)
                .forEach(kvp -> {
                    System.out.printf("Highest Average Salary: %s%n", kvp.getKey());
                    kvp.getValue().stream()
                            .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                            .forEach(System.out::println);
                });
    }
}
