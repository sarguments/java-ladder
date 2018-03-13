package saru;

import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> points;

    public Line(int columnNum) {
        points = new ArrayList<>(columnNum);
        for(int i = 0; i < columnNum; i++) {
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
        points.set(index, isLine);
    }
}
