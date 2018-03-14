package saru;

import java.util.ArrayList;

public class LadderOutput {
    public LadderOutput() {
    }

    void printLadderAndNames(ArrayList<String> names, ArrayList<Line> lines) {
        printNames(names);
        printLadder(lines);
    }

    void printNames(ArrayList<String> names) {
        for (String name : names) {
            System.out.printf("%-6s", name);
        }
        System.out.println();
    }

    void printLadder(ArrayList<Line> lines) {
        for (Line line : lines) {
            printMultiLines(line.getPoints());
        }
        System.out.println();
    }

    void printMultiLines(ArrayList<Boolean> arr) {
        for (int i = 0; i < arr.size(); i++) {
            printIndividualLine(arr, i);
        }

        System.out.println();
    }

    void printIndividualLine(ArrayList<Boolean> arr, int index) {
        if (index % 2 == 1) {
            printInterPoint(arr.get(index));
            return;
        }

        System.out.print("|");
    }

    void printInterPoint(boolean isTrue) {
        if (isTrue) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }
}
