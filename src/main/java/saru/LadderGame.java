package saru;

public class LadderGame {
    private String[][] ladderArr;

    public LadderGame() {
    }

    void initLadder(int ladderHeight, int realColumnNum) {
        ladderArr = new String[ladderHeight][realColumnNum];
        initLadderRowProc();
    }

    String[][] getLadderArr() {
        return ladderArr;
    }

    private void initLadderColumnProc(String[] colArr) {
        for (int i = 0; i < colArr.length; i++) {
            drawLineProc(colArr, i);
        }
    }

    private void initLadderRowProc() {
        for (int i = 0; i < ladderArr.length; i++) {
            initLadderColumnProc(ladderArr[i]);
        }
    }

    private void drawLineProc(String[] colArr, int index) {
        if (index % 2 == 1) {
            drawRowLine(colArr, index);
            return;
        }

        colArr[index] = "|";
    }

    private void drawRowLine(String[] colArr, int index) {
        if (LadderGameUtil.getRand(2) == 1) {
            colArr[index] = "-";
            return;
        }

        colArr[index] = " ";
        return;
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        int userNum = InputUtil.getUserNum();
        int height = InputUtil.getHeight();

        int columnNum = InputUtil.getRealColumnNum(userNum);
        ladderGame.initLadder(height, columnNum);

        OutputUtil.printRowArrays(ladderGame.getLadderArr(), height, columnNum);
    }
}