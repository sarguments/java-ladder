package saru;

import saru.domain.LadderGame;
import saru.view.LadderInput;
import saru.view.LadderOutput;

public class LadderMain {
    private static LadderInput ladderInput = new LadderInput();
    private static LadderOutput ladderOutput = new LadderOutput();

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
}
