package saru.view;

import saru.domain.LadderGame;
import saru.domain.Line;
import saru.domain.User;

import java.util.List;
import java.util.Scanner;

public class LadderOutput {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String RESULT_PROMPT = "결과를 보고 싶은 사람은?";
    private static final String ROW_BLANK_LINE = "     ";
    private static final String COLUMN_LINE = "|";
    private static final String ROW_LINE = "-----";

    public LadderOutput() {
    }

    public void sendOutputObject(LadderGame ladderGame) {
        printUserNames(ladderGame.getUsers());
        printLadder(ladderGame.getLadderLines());
        printDestination(ladderGame.getDestinations());

        boolean isAllResult = false;
        while (!isAllResult) {
            isAllResult = promptResult(ladderGame);
        }
    }

    private void printUserNames(List<User> users) {
        for (User user : users) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    // TODO 리팩토링 필요
    private boolean promptResult(LadderGame ladderGame) {
        System.out.println(RESULT_PROMPT);
        String userChoice = getUserChoice();

        List<User> users = ladderGame.getUsers();
        List<Integer> results = ladderGame.getResult();
        List<String> destination = ladderGame.getDestinations();

        if (userChoice.equals("all")) {
            printAllResult(users, results, destination);
            return true;
        }

        int matchIndex = getUserMatchIndex(users, userChoice);
        System.out.println(destination.get(results.get(matchIndex) / 2));

        return false;
    }

    // TODO 인덴트를 못 줄이겠습니다.
    private int getUserMatchIndex(List<User> users, String userName) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(userName)) {
                return i;
            }
        }

        return -1;
    }

    private void printAllResult(List<User> users, List<Integer> results, List<String> destination) {
        for (int i = 0; i < results.size(); i++) {
            System.out.println(users.get(i).getName() + " : " + destination.get(results.get(i) / 2));
        }
    }

    private String getUserChoice() {
        return scanner.nextLine();
    }

    private void printDestination(List<String> destinations) {
        for (String destination : destinations) {
            System.out.printf("%-6s", destination);
        }
        System.out.print("\n\n");
    }

    private void printLadder(List<Line> lines) {
        for (Line line : lines) {
            printMultiLines(line.getPoints());
        }
    }

    private void printMultiLines(List<Boolean> arr) {
        for (int i = 0; i < arr.size(); i++) {
            printIndividualLine(arr, i);
        }
        System.out.println();
    }

    private void printIndividualLine(List<Boolean> arr, int index) {
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
