package saru.domain;

import java.util.ArrayList;

public class Ladder {
    private enum LadderDir {
        LEFT,
        RIGHT,
        DOWN
    }

    private final ArrayList<Line> lines;

    public Ladder(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public ArrayList<Integer> climbLadder() {
        Position pos = new Position();

        // 반복 횟수
        int rotationNum = (lines.get(0).getPointsLength() + 1) / 2;
        return loopClimbLadderProc(pos, rotationNum);
    }

    private ArrayList<Integer> loopClimbLadderProc(Position pos, int rotationNum) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < rotationNum; i++) {
            // 0, 2, 4... 순서로 구한다.
            pos.setColumn(i * 2);
            pos.setRow(0);
            loopMovePosProc(pos);

            result.add(pos.getColumn());
        }

        return result;
    }

    private void loopMovePosProc(Position pos) {
        // 라인의 끝인지
        while (!checkEndRow(pos.getRow())) {
            movePos(pos, pos.getRow(), pos.getColumn());
        }
    }

    private void movePos(Position pos, int row, int column) {
        switch (checkDir(row, column)) {
            case LEFT:
                moveLeft(pos, row, column);
                break;
            case RIGHT:
                moveRight(pos, row, column);
                break;
            default:
                pos.setRow(row + 1);
        }
    }

    private void moveRight(Position pos, int localRow, int localColumn) {
        pos.setColumn(localColumn + 2);
        pos.setRow(localRow + 1);
    }

    private void moveLeft(Position pos, int localRow, int localColumn) {
        pos.setColumn(localColumn - 2);
        pos.setRow(localRow + 1);
    }

    private boolean checkEndRow(int rowIndex) {
        return this.lines.size() == rowIndex;
    }

    private LadderDir checkDir(int nowLine, int nowColumn) {
        Line line = lines.get(nowLine);

        // 어디로 갈지 판단
        if (line.checkSpecificPointHasLine(nowColumn - 1))
            return LadderDir.LEFT;

        if (line.checkSpecificPointHasLine(nowColumn + 1))
            return LadderDir.RIGHT;

        return LadderDir.DOWN;
    }
}

