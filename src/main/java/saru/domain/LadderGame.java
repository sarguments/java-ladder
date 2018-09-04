package saru.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGame {
    private static final int LIMIT = 4;

    private final List<User> users = new ArrayList<>();
    private final List<String> destinations = new ArrayList<>();
    private final List<Line> ladderLines = new ArrayList<>();
    private List<Integer> result;

    public LadderGame(int ladderHeight, String[] destination, String[] nameArray) {
        inputNames(nameArray);
        inputDestination(destination);
        initLadder(ladderHeight, nameArray.length);
        run();
    }

    private void run() {
        result = new Ladder(ladderLines).climbLadder();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public List<Line> getLadderLines() {
        return ladderLines;
    }

    public List<Integer> getResult() {
        return result;
    }

    private void inputNames(String[] nameArr) {
        // TODO User 객체 생성
        for (String aNameArr : nameArr) {
            users.add(new User(aNameArr));
        }
    }

    private void inputDestination(String[] destination) {
        Collections.addAll(destinations, destination);
    }

    private void initLadder(int ladderHeight, int columnNum) {
        int realColumnNum = getRealColumnNum(columnNum);
        for (int i = 0; i < ladderHeight; i++) {
            ladderLines.add(new Line(realColumnNum));
        }

        initLadderRowProc();
    }

    // 유저가 3명일 경우 5 (3 * 2 - 1) .. 식 자체를 상수화 하기는 어려울 것 같음.
    private int getRealColumnNum(int userNum) {
        return userNum * 2 - 1;
    }

    private void initLadderRowProc() {
        for (Line ladderLine : ladderLines) {
            initLadderColumnProc(ladderLine);
        }
    }

    private void initLadderColumnProc(Line colLine) {
        for (int i = 0; i < colLine.getPointsLength(); i++) {
            drawLineProc(colLine, i);
        }
    }

    private void drawLineProc(Line colLine, int index) {
        if (index % 2 == 1) {
            drawRowLine(colLine, index);
        }
    }

    private void drawRowLine(Line colLine, int index) {
        int randNum = LadderGameUtil.getRand(LIMIT);
        if (colLine.canDrawLine(randNum)) {
            colLine.drawPoint(index, true);
            return;
        }

        colLine.drawPoint(index, false);
    }
}