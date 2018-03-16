package saru.domain;

import java.util.ArrayList;

public class User {
    private static final int COLUMN = 2;

    private final ArrayList<Line> lineArrayList;
    private final String name;
    private int row = 0;
    private int column;

    private enum MoveDir {
        LEFT,
        RIGHT,
        DOWN
    }

    public User(int column, String name, ArrayList<Line> lineArrayList) {
        this.column = column;
        this.name = name;
        this.lineArrayList = lineArrayList;
    }

    public String getName() {
        return this.name;
    }

    public int getColumn() {
        return this.column;
    }

    void decisionMoveDir() {
        // 유저 위치가 목적지가 아닐 동안
        while (!checkEndRow()) {
            moveUserPosition(checkUserMoveDir());
        }
    }

    private MoveDir checkUserMoveDir() {
        Line line = lineArrayList.get(row);
        if (line.checkSpecificPointHasLine(column - 1)) {
            return MoveDir.LEFT;
        }

        if (line.checkSpecificPointHasLine(column + 1)) {
            return MoveDir.RIGHT;
        }
        return MoveDir.DOWN;
    }

    private void moveUserPosition(MoveDir moveDir) {
        switch (moveDir) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            default:
                moveDown();
                break;
        }
    }

    private void moveLeft() {
        this.column -= COLUMN;
        moveDown();
    }

    private void moveRight() {
        this.column += COLUMN;
        moveDown();
    }

    private void moveDown() {
        this.row++;
    }

    private boolean checkEndRow() {
        return row == lineArrayList.size();
    }
}