package saru;

import java.util.ArrayList;

public class OutputUtil {
    private OutputUtil() {
    }

    public static void printWholeArray(ArrayList<Line> lines) {
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

    // TODO 이름 입력받아서(5글자제한, 쉼표구분) 인원수 자동 카운트
    // TODO 사람 이름 출력
    // TODO 이름 길이에 따른 사다리폭 조절
    // TODO 라인 겹치지 않게
}
