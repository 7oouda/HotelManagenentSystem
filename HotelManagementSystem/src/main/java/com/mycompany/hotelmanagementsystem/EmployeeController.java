/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 20128
 * private String name;
    private Double salary;
    private int age;

 */
public class EmployeeController {
    public static void addEmployee(ArrayList<Employee> emp,Scanner scanner){
        System.out.println("Enter Emplyee name");
        String name=scanner.next();
        System.out.println("Enter Employee Salary");
        double salary=scanner.nextDouble();
        System.out.println("Enter Employee Job");
        String job=scanner.next();
        int id=emp.size();
        Employee employee=new Employee(id, name, salary, job);
        emp.add(employee);
        System.out.println("Employee Added Successfully");
        
    }
    public static void showEmployees(ArrayList<Employee>emp){
        for(Employee e:emp){
            e.toString();
        }
    }
    public static void editEmployee(ArrayList<Employee>emplyees,Scanner scanner){
         System.out.println("Enter Employee Id \n-1 to Show All Employees");
            int id=scanner.nextInt();
            if(id==-1){
                showEmployees(emplyees);
                System.out.println("Enter Employee Id ");
                id=scanner.nextInt();
                }
            Employee employee=emplyees.get(id);
            System.out.println("Enter Name: \n -1 to keep it");
            String name=scanner.next();
            if(name.equals("-1")){
                name=employee.getName();
            }
            System.out.println("Enter Salary: \n -1 to keep it");
            double salary=scanner.nextDouble();
            if(salary==-1){
                salary=employee.getSalary();
            }
            System.out.println("Enter Job: \n -1 to keep it");
            String job=scanner.next();
            if(job.equals("-1")){
                job=employee.getJob();
            }
            employee.setName(name);
            employee.setSalary(salary);
            employee.setJob(job);
            emplyees.set(id, employee);
            System.out.println("Employee Edited Successfully");
    }
}
