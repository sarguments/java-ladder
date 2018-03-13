package saru;

public class LadderGame {
    private Line[] ladderLines;

    public LadderGame() {
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.recursiveProc();
    }

    void recursiveProc() {
        int userNum = InputUtil.getUserNum();
        int height = InputUtil.getHeight();

        if (!InputUtil.checkValid(userNum, height)) {
            recursiveProc();
            return;
        }

        int columnNum = InputUtil.getRealColumnNum(userNum);
        this.initLadder(height, columnNum);

        OutputUtil.printWholeArray(this.getLadderLines());
    }

    Line[] getLadderLines() {
        return ladderLines;
    }

    void initLadder(int ladderHeight, int realColumnNum) {
        ladderLines = new Line[ladderHeight];

        for (int i = 0; i < ladderHeight; i++) {
            ladderLines[i] = new Line(realColumnNum);
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

        //colLine.drawPoint(index, false);
    }
    // 가로 선

    void drawRowLine(Line colLine, int index) {
        int randNum = LadderGameUtil.getRand(2);
        if (colLine.canDrawLine(randNum)) {
            colLine.drawPoint(index, true);
            return;
        }

        colLine.drawPoint(index, false);
    }
}