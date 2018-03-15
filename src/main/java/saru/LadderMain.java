package saru;

import saru.domain.LadderGame;
import saru.view.*;

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

        ladderOutput.sendOutputObject(new LadderGame(ladderHeight, nameArr));
    }
}
