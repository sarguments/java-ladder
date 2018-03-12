package saru;

public class Line {
    private String[] points;

    public Line(int columnNum) {
        points = new String[columnNum];
    }

    int getPointsLength() {
        return points.length;
    }
}
