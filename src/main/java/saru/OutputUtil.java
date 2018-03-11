package saru;

public class OutputUtil {
    private OutputUtil() {
    }

    public static void printArr(String[] arr, int columnNum) {
        for (int i = 0; i < columnNum; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();
    }
}
