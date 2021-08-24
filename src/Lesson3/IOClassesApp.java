package Lesson3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class IOClassesApp {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream( new FileOutputStream("log.txt"));
        printStream.println("Hello world");
        printStream.close();
    }
}
