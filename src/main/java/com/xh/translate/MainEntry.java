package com.xh.translate;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MainEntry {

    public static void main(String[] args) {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream("/Users/xh/Desktop/printStream.txt"), true);
            System.setOut(printStream);

            System.out.println("Hello World");
            System.out.println("Nice to meet you");


            throw new NullPointerException("this is a NullPointerException");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
