package saru.view;

import saru.domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LadderOutput {
    public static final String RESULT_PROMPT = "결과를 보고 싶은 사람은?";
    private static final int COLUMN = 2;
    private static final Scanner scanner = new Scanner(System.in);

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

    private void printUserNames(ArrayList<User> users) {
        for (User user : users) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    private boolean promptResult(LadderGame ladderGame) {
        System.out.println(RESULT_PROMPT);
        
        String userChoice = getUserChoice();
        if (checkIsAllResult(ladderGame, userChoice)) return true;

        ArrayList<User> users = ladderGame.getUsers();
        for (User user : users) {
            if (findResultDestination(ladderGame, userChoice, user)) return false;
        }
        return false;
    }

    private boolean checkIsAllResult(LadderGame ladderGame, String userChoice) {
        if (userChoice.equals("all")) {
            printResultAll(ladderGame.getUsers(), ladderGame.getDestinations());
            return true;
        }
        return false;
    }

    private boolean findResultDestination(LadderGame ladderGame, String userChoice, User user) {
        if (user.getName().equals(userChoice)) {
            // 개별 출력
            printOneResult(user.getColumn() / COLUMN, ladderGame.getDestinations());
            return true;
        }
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

    private void printResultAll(ArrayList<User> users, ArrayList<String> destination) {
        // 각 사용자의 컬럼값에 해당하는 destination 값
        for (User user : users) {
            System.out.printf("%s : %-6s\n", user.getName(), destination.get(user.getColumn() / COLUMN));
        }
    }

    private void printOneResult(int userIndex, ArrayList<String> destination) {
        System.out.printf("%-6s\n", destination.get(userIndex));
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
        System.out.print("|");
    }

    private void printInterPoint(boolean isTrue) {
        if (isTrue) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }
}
