package saru;

import java.util.ArrayList;
import java.util.Collections;

public class LadderGame {
    public static final int LIMIT = 4;

    private static LadderInput ladderInput = new LadderInput();
    private static LadderOutput ladderOutput = new LadderOutput();

    private ArrayList<Line> ladderLines;
    private ArrayList<String> names = new ArrayList<>();

    public LadderGame(int ladderHeight, String[] nameArray) {
        inputNames(nameArray);
        initLadder(ladderHeight, nameArray.length);
    }

    public static void main(String[] args) {
        String[] nameArr;
        int ladderHeight;

        do {
            nameArr = ladderInput.getUserName();
            ladderHeight = ladderInput.getHeight();
            ladderInput.flush();
        } while (!ladderInput.checkValid(nameArr, ladderHeight));

        LadderGame ladderGame = new LadderGame(ladderHeight, nameArr);

        ladderOutput.printLadderAndNames(ladderGame.getNames(), ladderGame.getLadderLines());
    }

    // 유저가 3명일 경우 5 (3 * 2 - 1) .. 식 자체를 상수화 하기는 어려울 것 같음.
    int getRealColumnNum(int userNum) {
        return userNum * 2 - 1;
    }

    void inputNames(String[] nameArr) {
        Collections.addAll(names, nameArr);
    }

    ArrayList<String> getNames() {
        return names;
    }

    ArrayList<Line> getLadderLines() {
        return ladderLines;
    }

    void initLadder(int ladderHeight, int columnNum) {
        ladderLines = new ArrayList<>(ladderHeight);
        int realColumnNum = getRealColumnNum(columnNum);

        for (int i = 0; i < ladderHeight; i++) {
            ladderLines.add(new Line(realColumnNum));
        }

        initLadderRowProc();
    }

    void initLadderRowProc() {
        for (Line ladderLine : ladderLines) {
            initLadderColumnProc(ladderLine);
        }
    }

    void initLadderColumnProc(Line colLine) {
        for (int i = 0; i < colLine.getPointsLength(); i++) {
            drawLineProc(colLine, i);
        }
    }

    void drawLineProc(Line colLine, int index) {
        if (index % 2 == 1) {
            drawRowLine(colLine, index);
            return;
        }
    }

    void drawRowLine(Line colLine, int index) {
        int randNum = LadderGameUtil.getRand(LIMIT);
        if (colLine.canDrawLine(randNum)) {
            colLine.drawPoint(index, true);
            return;
        }

        colLine.drawPoint(index, false);
    }
}