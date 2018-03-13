package saru;

import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> points;

    public Line(int columnNum) {
        points = new ArrayList<>(columnNum);
        for (int i = 0; i < columnNum; i++) {
            points.add(false);
        }
    }

    ArrayList<Boolean> getPoints() {
        return points;
    }

    int getPointsLength() {
        return points.size();
    }

    boolean canDrawLine(int randNum) {
        if (randNum == 1) {
            return true;
        }
        return false;
    }

    void drawPoint(int index, boolean isLine) {
        // 오른쪽 방향으로 진행하면서 왼쪽에 없으면 생성하도록
        // 1은 무조건 만들 수 있음
        if (index > 2 && (index < points.size() - 1) &&
                // 기준 선 사이를 확인해야 하므로 - 2
                checkPointHasInterLine(index - 2)) {

            return;
        }

        points.set(index, isLine);
    }

    boolean checkPointHasInterLine(int index) {
        boolean isLineExist = points.get(index);
        return isLineExist;
    }
}
