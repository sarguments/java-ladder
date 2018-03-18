package saru.domain;

import java.util.ArrayList;
import java.util.List;

//import static saru.domain.LadderPointGenerator.generatePoint;

/*
사다리 한 Line 추상화
사다리 게임에서 한 Line을 LadderLine으로 이름을 붙이고 다음과 같이 구현
사다리 Line의 모든 Point 초기화와 이동을 담당
 */

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    // 마지막 컬럼 point 초기화
    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    // 첫 컬럼 point 초기화
    private static Point initFirst(List<Point> points) {
        // TODO 왜 first만 인자를 받지?
        // 왼쪽에서 오른쪽으로 초기화 하니까 마지막은 볼 필요 없어서?
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        return "LadderLine{" + "points=" + points + '}';
    }
}