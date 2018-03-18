package saru.domain;

import java.util.*;

public class LadderGame {
    private static final int LIMIT = 4;

    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<String> destinations = new ArrayList<>();
    private final ArrayList<Line> ladderLines = new ArrayList<>();

    public LadderGame(int ladderHeight, String[] destination, String[] nameArray) {
        inputNames(nameArray);
        inputDestination(destination);
        initLadder(ladderHeight, nameArray.length);

        // TODO ArrayList 리턴?
        Ladder ladder = new Ladder(ladderLines);
        ladder.climbLadder();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    // TODO Line 리스트 가져오기
    public ArrayList<Line> getLadderLines() {
        return ladderLines;
    }

    public ArrayList<String> getDestinations() {
        return destinations;
    }

    private void inputNames(String[] nameArr) {
        // TODO User 객체 생성
        for (int i = 0; i < nameArr.length; i++) {
            users.add(new User(nameArr[i]));
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

        // TODO Ladder 클래스?
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