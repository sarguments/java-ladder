package saru.domain;

import static saru.domain.LadderPointGenerator.generateRandPoint;
import static java.lang.Boolean.FALSE;

import java.util.Objects;

public class Direction {
    private final boolean prev;
    private final boolean cur;

    private Direction(boolean prev, boolean cur) {
        if (prev && cur) {
            throw new IllegalStateException();
        }

        this.prev = prev;
        this.cur = cur;
    }

    public boolean isCur() {
        return this.cur;
    }

    public boolean isPrev() {
        return this.prev;
    }

    public Direction next(boolean nextCur) {
        return of(this.cur, nextCur);
    }

    public Direction next() {
        // 현재 cur가 true면 그 다음은 무조건 false
        if (this.cur) {
            return next(FALSE);
        }
        // 만들 수 있으면 랜덤
        return next(generateRandPoint());
    }

    // 팩토리 메서드. Instance of Direction
    public static Direction of(boolean prev, boolean cur) {
        return new Direction(prev, cur);
    }

    // 첫 컬럼은 prev가 false
    public static Direction first(boolean cur) {
        return of(FALSE, cur);
    }

    // 마지막 컬럼은 cur가 false(더이상 없으니까)
    public Direction last() {
        return of(this.cur, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return prev == pair.prev &&
                cur == pair.cur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prev, cur);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "prev=" + prev +
                ", cur=" + cur +
                '}';
    }
}