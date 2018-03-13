package saru;

public class OutputUtil {
    private OutputUtil() {
    }

    public static void printWholeArray(Line[] lines) {
        for (int i = 0; i < lines.length; i++) {
            OutputUtil.printMultiLines(lines[i].getPoints());
        }

        System.out.println();
    }

    public static void printMultiLines(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            printIndividualLine(arr, i);
        }

        System.out.println();
    }

    public static void printIndividualLine(boolean[] arr, int index) {
        if (index % 2 == 1) {
            printInterPoint(arr[index], index);
            return;
        }

        System.out.print("|");
    }

    public static void printInterPoint(boolean isTrue, int index) {
        if (isTrue) {
            System.out.print("-");
            return;
        }
        System.out.print(" ");
    }
}
