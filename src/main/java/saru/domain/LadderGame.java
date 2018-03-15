package saru.domain;

import java.util.ArrayList;
import java.util.Collections;

// TODO 각각의 역할에 맞도록 패키지를 분리하고 접근 제어자를 적절히 사용하도록 리팩토링한다.

public class LadderGame {
    private static final int LIMIT = 4;

    private ArrayList<Line> ladderLines;
    private ArrayList<String> names = new ArrayList<>();

    public LadderGame(int ladderHeight, String[] nameArray) {
        inputNames(nameArray);
        initLadder(ladderHeight, nameArray.length);
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Line> getLadderLines() {
        return ladderLines;
    }

    private void inputNames(String[] nameArr) {
        Collections.addAll(names, nameArr);
    }

    private void initLadder(int ladderHeight, int columnNum) {
        ladderLines = new ArrayList<>(ladderHeight);
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
            return;
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