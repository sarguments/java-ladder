package saru.domain;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    Position moveRightDown() {
        return new Position(this.row + 1, this.column + 2);
    }

    Position moveLeftDown() {
        return new Position(this.row + 1, this.column - 2);
    }

    Position moveDown() {
        return new Position(this.row + 1, this.column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
