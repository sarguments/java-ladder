package saru;

public class LadderGame {
    private Line[] ladderLines;

    public LadderGame() {
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

        colLine.drawPoint(index, "|");
    }

    // 가로 선
    void drawRowLine(Line colLine, int index) {
        int randNum = LadderGameUtil.getRand(2);
        if (colLine.canDrawLine(randNum)) {
            colLine.drawPoint(index, "-");
            return;
        }

        colLine.drawPoint(index, " ");
    }

    ///////////////////////////////////////////////////////////////

    Line[] getLadderLines() {
        return ladderLines;
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        int userNum = InputUtil.getUserNum();
        int height = InputUtil.getHeight();

        if (InputUtil.checkValid(userNum, height)) return;

        int columnNum = InputUtil.getRealColumnNum(userNum);
        ladderGame.initLadder(height, columnNum);

        OutputUtil.printRowArray(ladderGame.getLadderLines());
    }
}