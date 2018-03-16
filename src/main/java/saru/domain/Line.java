package saru.domain;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> points;

    public Line(int columnNum) {
        points = new ArrayList<>(columnNum);
        for (int i = 0; i < columnNum; i++) {
            points.add(false);
        }
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }

    // 오른쪽 방향으로 진행하면서 왼쪽에 없으면 생성하도록
    public boolean checkPointHasLeftLine(int index) {
        if (index < 2) {
            // 1은 무조건 만들 수 있음
            return true;
        }

        // 인덱스 범위 체크
        if (index < points.size() - 1) {
            // 기준 선 사이를 확인해야 하므로 - 2
            // 왼쪽에 선이 이미 있으면 false, 없으면 true
            return (!points.get(index - 2));
        }

        // 범위에 맞지 않으면 false
        return false;
    }

    // TODO : 라인의 특정 인덱스에 선이 있는지 없는지
    boolean checkSpecificPointHasLine(int index) {
        // 인덱스 범위 체크
        if (index < 0 || index > points.size() - 1) {
            return false;
        }

        return points.get(index);
    }

    int getPointsLength() {
        return points.size();
    }

    boolean canDrawLine(int randNum) {
        return randNum == 1;
    }

    void drawPoint(int index, boolean isLine) {
        // 범위가 잘못 되었거나 왼쪽에 선이 이미 있을 경우 그냥 return
        if (!checkPointHasLeftLine(index)) {
            return;
        }

        points.set(index, isLine);
    }
}
