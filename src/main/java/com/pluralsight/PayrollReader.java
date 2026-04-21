package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PayrollReader {
    public static void main(String[] args) {
        try {
            FileReader fileReader=new FileReader("src/main/resources/employee.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;

            while((input = bufReader.readLine()) != null) {
                System.out.println(input);
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
