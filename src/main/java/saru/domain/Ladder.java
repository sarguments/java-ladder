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
        return loopClimbLadderProc();
    }

    private ArrayList<Integer> loopClimbLadderProc() {
        ArrayList<Integer> result = new ArrayList<>();
        int rotationNum = (lines.get(0).getPointsLength() + 1) / 2;

        for (int i = 0; i < rotationNum; i++) {
            // 0, 2, 4... 순서로 구한다.
            Position pos = new Position(0, i * 2);
            loopMovePosProc(pos);
            result.add(pos.getColumn());
        }

        return result;
    }

    private void loopMovePosProc(Position pos) {
        // 라인의 끝인지
        while (!checkEndRow(pos.getRow())) {
            movePos(pos);
        }
    }

    private void movePos(Position pos) {
        switch (checkDir(pos.getRow(), pos.getColumn())) {
            case LEFT:
                moveLeftDown(pos);
                break;
            case RIGHT:
                moveRightDown(pos);
                break;
            default:
                pos.moveDown();
        }
    }

    // TODO 이 로직을 Position에 구현할 수는 없을까
    private void moveRightDown(Position pos) {
        pos.moveRight();
        pos.moveDown();
    }

    // TODO Position의 상태 값을 변경한 후 새로운 Position을 생성해 메소드로 반환
    private void moveLeftDown(Position pos) {
        pos.moveLeft();
        pos.moveDown();
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

