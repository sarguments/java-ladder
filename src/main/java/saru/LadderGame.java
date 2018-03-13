package saru;

import java.util.ArrayList;

public class LadderGame {
    private ArrayList<Line> ladderLines;
    private ArrayList<String> names = new ArrayList<>();

    public LadderGame() {
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.recursiveProc();
    }

    void recursiveProc() {
        String[] nameArr = InputUtil.getUserName();
        inputNames(nameArr);

        int height = InputUtil.getHeight();

        if (!InputUtil.checkValid(nameArr, height)) {
            clearBeforeRecursive();
            recursiveProc();
            return;
        }

        this.initLadder(height, InputUtil.getRealColumnNum(nameArr.length));

        OutputUtil.printLadderAndNames(this.names, this.getLadderLines());
    }

    void clearBeforeRecursive() {
        names.clear();
        InputUtil.flush();
    }

    void inputNames(String[] nameArr) {
        for (String str : nameArr) {
            names.add(str);
        }
    }

    ArrayList<Line> getLadderLines() {
        return ladderLines;
    }

    void initLadder(int ladderHeight, int realColumnNum) {
        ladderLines = new ArrayList<>(ladderHeight);

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
        int randNum = LadderGameUtil.getRand(4);
        if (colLine.canDrawLine(randNum)) {
            colLine.drawPoint(index, true);
            return;
        }

        colLine.drawPoint(index, false);
    }
}