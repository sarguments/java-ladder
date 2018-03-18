package saru.view;

import saru.domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LadderOutput {
    public static final String RESULT_PROMPT = "결과를 보고 싶은 사람은?";
    public static final String ROW_BLANK_LINE = "     ";
    public static final String COLUMN_LINE = "|";
    public static final String ROW_LINE = "-----";
    private static final Scanner scanner = new Scanner(System.in);

    public LadderOutput() {
    }

    public void sendOutputObject(LadderGame ladderGame) {
        printUserNames(ladderGame.getUsers());
        printLadder(ladderGame.getLadderLines());
        printDestination(ladderGame.getDestinations());

//        boolean isAllResult = false;
//        while (!isAllResult) {
//            isAllResult = promptResult(ladderGame);
//        }
    }

    private void printUserNames(ArrayList<User> users) {
        for (User user : users) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    private boolean promptResult(LadderGame ladderGame) {
        System.out.println(RESULT_PROMPT);

        String userChoice = getUserChoice();

        return false;
    }

    private String getUserChoice() {
        return scanner.nextLine();
    }

    private void printDestination(ArrayList<String> destinations) {
        for (String destination : destinations) {
            System.out.printf("%-6s", destination);
        }
        System.out.print("\n\n");
    }

    private void printLadder(ArrayList<Line> lines) {
        for (Line line : lines) {
            printMultiLines(line.getPoints());
        }
    }

    private void printMultiLines(ArrayList<Boolean> arr) {
        for (int i = 0; i < arr.size(); i++) {
            printIndividualLine(arr, i);
        }
        System.out.println();
    }

    private void printIndividualLine(ArrayList<Boolean> arr, int index) {
        if (index % 2 == 1) {
            printInterPoint(arr.get(index));
            return;
        }
        System.out.print(COLUMN_LINE);
    }

    private void printInterPoint(boolean isTrue) {
        if (isTrue) {
            System.out.print(ROW_LINE);
            return;
        }
        System.out.print(ROW_BLANK_LINE);
    }
}
