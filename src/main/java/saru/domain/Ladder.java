package saru.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Integer> climbLadder() {
        return loopClimbLadderProc();
    }

    private List<Integer> loopClimbLadderProc() {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < getRotateNum(); i++) {
            // 0, 2, 4... 순서로 구한다.
            Position pos = new Position(0, i * 2);
            pos = loopMovePosProc(pos);
            result.add(pos.getColumn());
        }

        return result;
    }

    private Position loopMovePosProc(Position pos) {
        // 라인의 끝인지
        while (!checkEndRow(pos.getRow())) {
            pos = movePos(pos);
        }

        return pos;
    }

    private Position movePos(Position pos) {
        switch (checkDir(pos.getRow(), pos.getColumn())) {
            case LEFT:
                return moveLeftDown(pos);
            case RIGHT:
                return moveRightDown(pos);
            default:
                return pos.moveDown();
        }
    }

    private Position moveRightDown(Position pos) {
        return pos.moveRightDown();
    }

    private Position moveLeftDown(Position pos) {
        return pos.moveLeftDown();
    }

    private int getRotateNum() {
        return (lines.get(0).getPointsLength() + 1) / 2;
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

    private enum LadderDir {
        LEFT,
        RIGHT,
        DOWN
    }
}

