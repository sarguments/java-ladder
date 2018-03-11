package saru;

import java.util.Scanner;

public class InputUtil {
    private InputUtil() {
    }

    private static Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.next();
    }
}
