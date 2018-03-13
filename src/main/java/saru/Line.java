package saru;

public class Line {
    private String[] points;

    public Line(int columnNum) {
        points = new String[columnNum];
    }

    String[] getPoints() {
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

    void drawPoint(int index, String str) {
        points[index] = str;
    }
}
