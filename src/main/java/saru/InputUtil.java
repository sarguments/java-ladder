package saru;

import java.util.Scanner;

public class InputUtil {
    public static final String INCORRECT_NAME_INPUT = "제대로 입력하세요";
    public static final String INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_MAX_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";
    public static final String REGEX = ",";

    private InputUtil() {
    }

    private static Scanner scanner = new Scanner(System.in);

//    private static String getUserInput() {
//        return scanner.next();
//    }

    public static int getRealColumnNum(int userNum) {
        return userNum * 2 - 1;
    }

    public static boolean checkValid(String[] names, int height) {
        if (names.length <= 0 || height <= 0) {
            System.out.println(INCORRECT_NAME_INPUT);
            return false;
        }

        for (String name : names) {
            if (checkNameLength(name)) return false;
        }

        return true;
    }

    public static boolean checkNameLength(String name) {
        if (name.length() > 5) {
            return true;
        }
        return false;
    }

    public static String[] getUserName() {
        System.out.println(INPUT_USER_NAMES);
        String userInput = InputUtil.scanner.nextLine();
        return userInput.split(REGEX);
    }

    public static int getHeight() {
        String userInput;

        System.out.println(INPUT_MAX_LADDER_LENGTH);
        userInput = InputUtil.scanner.next();
        return Integer.parseInt(userInput);
    }

    public static void flush() {
        scanner.nextLine();
    }
}
