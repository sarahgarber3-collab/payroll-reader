package com.pluralsight;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PayrollReader {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("--Welcome to file Writer--");
        System.out.print("Enter the name of the file employee file to process: ");
        String fileName = scan.nextLine();
        System.out.print("Enter the name of the payroll file to create: ");
        String payrollName = scan.nextLine();


        try {
            FileReader fileReader=new FileReader("src/main/resources/employee.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("src/main/resources/employeePay.csv"));

            String input;
            String text;
            bufReader.readLine();

            while((input = bufReader.readLine()) != null) {
                String[] parts = input.split("\\|");
                int employeeId = Integer.parseInt(parts[0]);
                String name = parts[1];
                float hoursWorked = Float.parseFloat(parts[2]);
                float payRate = Float.parseFloat(parts[3]);

                Employee emp = new Employee(employeeId, name, hoursWorked, payRate);
                System.out.printf("id:%d Name:%s, Gross Pay:$%.2f%n" , emp.getEmployeeId() ,emp.getName(), emp.getGrossPay());


                bufWriter.write(String.format("%d | %s | $%.2f%n",emp.getEmployeeId() ,emp.getName(), emp.getGrossPay()));
            }





            bufReader.close();
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
