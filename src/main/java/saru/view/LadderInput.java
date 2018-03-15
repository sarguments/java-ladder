package saru.view;

import java.util.Scanner;

public class LadderInput {
    public static final String INCORRECT_HEIGHT_INPUT = "높이를 제대로 입력하세요";
    public static final String INCORRECT_NAME_INPUT = "이름을 제대로 입력하세요";
    public static final String INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_MAX_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";
    public static final String REGEX = ",";
    public static final int MAX_NAME_LENGTH = 5;

    private static Scanner scanner = new Scanner(System.in);

    public LadderInput() {
    }

    public boolean checkValid(String[] names, int height) {
        if (height <= 0) {
            System.out.println(INCORRECT_HEIGHT_INPUT);
            return false;
        }

        if (names.length <= 0 || !checkNamesProc(names)) {
            System.out.println(INCORRECT_NAME_INPUT);
            return false;
        }

        return true;
    }

    public String[] getUserName() {
        System.out.println(INPUT_USER_NAMES);
        String userInput = LadderInput.scanner.nextLine();
        return userInput.split(REGEX);
    }

    public int getHeight() {
        String userInput;

        System.out.println(INPUT_MAX_LADDER_LENGTH);
        userInput = LadderInput.scanner.next();
        return Integer.parseInt(userInput);
    }

    public void flush() {
        scanner.nextLine();
    }

    private boolean checkNamesProc(String[] names) {
        int faultNum = 0;

        for (String name : names) {
            faultNum += countCheckNameFault(name);
        }

        return faultNum == 0;
    }

    private int countCheckNameFault(String name) {
        return checkNameLength(name) ? 0 : 1;
    }

    private boolean checkNameLength(String name) {
        return (name.length() > MAX_NAME_LENGTH) ? false : true;
    }
}
