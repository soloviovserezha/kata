package utils;

import java.util.Scanner;

public class CreateScanner {
    private Scanner scanner;

    public Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
