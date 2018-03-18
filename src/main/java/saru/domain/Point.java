package saru.domain;

/*
LadderLine의 두 점과 현재 위치를 Point로 추상화
LadderLine에서 위치와 각 점의 방향을 관리
 */

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    // TODO point next 안에서 direction next 호출
    public Point next() {
        return new Point(index + 1, direction.next());
    }

    // TODO 출력용?
    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return "Point{" + "index=" + index + ", direction=" + direction + '}';
    }
}