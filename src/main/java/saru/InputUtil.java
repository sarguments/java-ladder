package saru;

import java.util.Scanner;

public class InputUtil {
    private InputUtil() {
    }

    private static Scanner scanner = new Scanner(System.in);

    private static String getUserInput() {
        return scanner.next();
    }

    public static int getRealColumnNum(int userNum) {
        return userNum * 2 - 1;
    }

    public static boolean checkValid(int userNum, int height) {
        if (userNum < 0 || height < 0) {
            System.out.println("제대로 입력하세요");
            return false;
        }
        return true;
    }

    public static int getUserNum() {
        System.out.println("유저수:");
        String userInput = InputUtil.getUserInput();
        return Integer.parseInt(userInput);
    }

    public static int getHeight() {
        String userInput;

        System.out.println("높이");
        userInput = InputUtil.getUserInput();
        return Integer.parseInt(userInput);
    }
}
