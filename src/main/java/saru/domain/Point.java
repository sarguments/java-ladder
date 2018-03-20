package saru.domain;

public class Point {
    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int move() {
        // 현재 Point(right)에 이어진 선이 있으면
        if (direction.isCur()) {
            return index + 1;
        }

        // 이전 Point(left)에 이어진 선이 있으면
        if (direction.isPrev()) {
            return index - 1;
        }

        return this.index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(Boolean nextCur) {
        return new Point(index + 1, direction.next(nextCur));
    }

    public Point last() {
        // 라스트가 + 1 인건 순서대로 ++
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean cur) {
        return new Point(0, Direction.first(cur));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}