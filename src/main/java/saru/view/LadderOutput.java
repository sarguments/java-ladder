package saru.view;

import saru.domain.*;

import java.util.ArrayList;

public class LadderOutput {
    private LadderGame ladderGame;

    public LadderOutput() {
    }

    public void sendOutputObject(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
        printNames(ladderGame.getNames());
        printLadder(ladderGame.getLadderLines());
    }

    private void printNames(ArrayList<String> names) {
        for (String name : names) {
            System.out.printf("%-6s", name);
        }
        System.out.println();
    }

    private void printLadder(ArrayList<Line> lines) {
        for (Line line : lines) {
            printMultiLines(line.getPoints());
        }
        System.out.println();
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
