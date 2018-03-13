package saru;

public class OutputUtil {
    private OutputUtil() {
    }

    public static void printLines(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();
    }

    public static void printRowArray(Line[] lines) {
        for (int i = 0; i < lines.length; i++) {
            OutputUtil.printLines(lines[i].getPoints());
        }

        System.out.println();
    }
}
