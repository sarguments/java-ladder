package saru.domain;

import java.util.ArrayList;

public class User {
    private static final int COLUMN = 2;

    private String name;
    private int row = 0;
    private int column;
    private ArrayList<Line> lineArrayList;

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

    int decisionMoveDir() {
        // 유저 위치가 목적지가 아닐 동안
        while (!checkEndRow()) {
            moveUserPosition(checkUserMoveDir());
        }

        return this.column;
    }

    MoveDir checkUserMoveDir() {
        Line line = lineArrayList.get(row);
        if (line.checkSpecificPointHasLine(column - 1)) {
            return MoveDir.LEFT;
        }

        if (line.checkSpecificPointHasLine(column + 1)) {
            return MoveDir.RIGHT;
        }
        return MoveDir.DOWN;
    }

    void moveUserPosition(MoveDir moveDir) {
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

    void moveLeft() {
        this.column -= COLUMN;
        moveDown();
    }

    void moveRight() {
        this.column += COLUMN;
        moveDown();
    }

    void moveDown() {
        this.row++;
    }

    boolean checkEndRow() {
        if (row == lineArrayList.size()) {
            return true;
        }
        return false;
    }
}