package saru;

import java.util.Random;

public class LadderGame {
    public LadderGame() {
    }

    void inputProc() {
        System.out.println("유저수:");
        String userInput = InputUtil.getUserInput();
        int userNum = Integer.parseInt(userInput);

        System.out.println("높이");
        userInput = InputUtil.getUserInput();

        int realColumnNum = userNum * 2 - 1;
        int ladderHeight = Integer.parseInt(userInput);

        initLadder(ladderHeight, realColumnNum);
    }

    void printLadder() {
        for(int i = 0; i < ladderHeight; i++) {
            OutputUtil.printArr(ladderArr[i], realColumnNum);
        }
    }

    private int ladderHeight;
    private int realColumnNum;
    private String[][] ladderArr;
    private Random random = new Random();

    private void initLadder(int ladderHeight, int realColumnNum) {
        this.ladderHeight = ladderHeight;
        this.realColumnNum = realColumnNum;

        ladderArr = new String[ladderHeight][realColumnNum];
        initLadderRowProc();
    }

    private void initLadderColumnProc(String[] colArr) {
        for (int i = 0; i < realColumnNum; i++) {
            drawLineProc(colArr, i);
        }
    }

    private void initLadderRowProc() {
        for(int i = 0; i < ladderHeight; i++) {
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
        if (random.nextInt(2) == 1) {
            colArr[index] = "-";
            return;
        }

        colArr[index] = " ";
        return;
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.inputProc();
        ladderGame.printLadder();
    }
}