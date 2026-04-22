package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollReader {
    public static void main(String[] args) {
        try {
            FileReader fileReader=new FileReader("src/main/resources/employee.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;
            bufReader.readLine();

            while((input = bufReader.readLine()) != null) {
                String[] parts = input.split("\\|");
                int employeeId = Integer.parseInt(parts[0]);
                String name = parts[1];
                float hoursWorked = Float.parseFloat(parts[2]);
                float payRate = Float.parseFloat(parts[3]);

                Employee emp = new Employee(employeeId, name, hoursWorked, payRate);
                System.out.println(emp.getName() + " - Gross Pay: $" + emp.getGrossPay());

                try {
                    Thread.sleep(600); //pauses program, for ms time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
