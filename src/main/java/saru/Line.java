package saru;

public class Line {
    private boolean[] points;

    public Line(int columnNum) {
        points = new boolean[columnNum];
    }

    boolean[] getPoints() {
        return points;
    }

    int getPointsLength() {
        return points.length;
    }

    boolean canDrawLine(int randNum) {
        if (randNum == 1) {
            return true;
        }
        return false;
    }

    void drawPoint(int index, boolean isLine) {
        points[index] = isLine;
    }
}
