package saru;

import java.util.ArrayList;

public class OutputUtil {
    private OutputUtil() {
    }

    public static void printLadderAndNames(ArrayList<String> names, ArrayList<Line> lines) {
        printNames(names);
        printLadder(lines);
    }

    public static void printNames(ArrayList<String> names) {
        for (String name : names) {
            System.out.printf("%-6s", name);
        }
        System.out.println();
    }

    public static void printLadder(ArrayList<Line> lines) {
        for (Line line : lines) {
            OutputUtil.printMultiLines(line.getPoints());
        }
        System.out.println();
    }

    public static void printMultiLines(ArrayList<Boolean> arr) {
        for (int i = 0; i < arr.size(); i++) {
            printIndividualLine(arr, i);
        }

        System.out.println();
    }

    public static void printIndividualLine(ArrayList<Boolean> arr, int index) {
        if (index % 2 == 1) {
            printInterPoint(arr.get(index));
            return;
        }

        System.out.print("|");
    }

    public static void printInterPoint(boolean isTrue) {
        if (isTrue) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }
}
