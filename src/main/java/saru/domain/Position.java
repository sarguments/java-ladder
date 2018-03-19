package saru.domain;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    void moveRight() {
        this.column += 2;
    }

    void moveLeft() {
        this.column -= 2;
    }

    void moveDown() {
        this.row += 1;
    }

    // TODO  Position에 메시지를 보내 로직을 처리한 후 반환
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
