package saru.view;

import java.util.Scanner;

public class LadderInput {
    private static final String INCORRECT_NAME_INPUT = "이름을 제대로 입력하세요";
    private static final String INCORRECT_DESTINATION = "실행 결과를 제대로 입력하세요";
    private static final String INCORRECT_HEIGHT_INPUT = "높이를 제대로 입력하세요";
    private static final String INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_DESTINATION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";
    private static final String REGEX = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);

    public LadderInput() {
    }

    public boolean checkValid(String[] names, String[] destination, int height) {
        if (checkCondition(height <= 0, INCORRECT_HEIGHT_INPUT))
            return false;

        if (checkCondition(!checkNamesProc(names), INCORRECT_NAME_INPUT))
            return false;

        return !checkCondition(!checkNamesProc(destination), INCORRECT_DESTINATION);
    }

    public String[] getUserName() {
        System.out.println(INPUT_USER_NAMES);
        String userInput = LadderInput.scanner.nextLine();
        return userInput.split(REGEX);
    }

    public String[] getDestination() {
        System.out.println(INPUT_DESTINATION);
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

    private boolean checkCondition(boolean condition, String errorMsg) {
        if (condition) {
            System.out.println(errorMsg);
            return true;
        }
        return false;
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
        return name.length() <= MAX_NAME_LENGTH;
    }
}
