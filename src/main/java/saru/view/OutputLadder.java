package saru.view;

import saru.domain.*;

import java.util.*;

public class OutputLadder {
    private static final String RESULT_PROMPT = "결과를 보고 싶은 사람은?";
    private static final String HORIZON = "-----";
    private static final String VERTICAL = "|";
    private static final String BLANK = "     ";
    private static final Scanner scanner = new Scanner(System.in);

    public OutputLadder() {
        // empty
    }

    private void printLadder(List<LadderLine> lines) {
        for (LadderLine line : lines) {
            List<Point> points = line.getPoints();

            printPoints(points);
        }
    }

    private void printPoints(List<Point> points) {
        for (Point point : points) {
            Direction direction = point.getDirection();

            System.out.print(VERTICAL);
            printHorizon(direction);
        }
        System.out.println();
    }

    private void printHorizon(Direction direction) {
        if (direction.isCur()) {
            System.out.print(HORIZON);
            return;
        }
        System.out.print(BLANK);
    }

    public void sendOutputObject(LadderGame ladderGame) {
        printUserNames(ladderGame.getNames());
        printLadder(ladderGame.getLines());
        printDestination(ladderGame.getDestination());

        boolean isAllResult = false;
        while (!isAllResult) {
            isAllResult = promptResult(ladderGame);
        }
    }

    private void printUserNames(List<String> users) {
        for (String user : users) {
            System.out.printf("%-6s", user);
        }
        System.out.println();
    }

    // TODO 리팩토링 필요
    private boolean promptResult(LadderGame ladderGame) {
        System.out.println(RESULT_PROMPT);
        String userChoice = getUserChoice();

        List<String> names = ladderGame.getNames();
        List<Integer> results = ladderGame.getResult();
        List<String> destination = ladderGame.getDestination();

        if (userChoice.equals("all")) {
            printAllResult(names, results, destination);
            return true;
        }

        int matchIndex = getUserMatchIndex(names, userChoice);
        System.out.println(destination.get(results.get(matchIndex)));

        return false;
    }

    // TODO 인덴트
    private int getUserMatchIndex(List<String> names, String userName) {

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(userName)) {
                return i;
            }
        }

        return -1;
    }

    private void printAllResult(List<String> names, List<Integer> results, List<String> destination) {
        for (int i = 0; i < results.size(); i++) {
            System.out.println(names.get(i) + " : " + destination.get(results.get(i)));
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
}