package saru;

import saru.domain.*;
import saru.view.InputLadder;
import saru.view.OutputLadder;

public class LadderMain {
    private static final InputLadder ladderInput = new InputLadder();
    private static final OutputLadder ladderOutput = new OutputLadder();

    public static void main(String[] args) {
        String[] nameArr, destination;
        int ladderHeight;

        do {
            nameArr = ladderInput.getUserName();
            destination = ladderInput.getDestination();
            ladderHeight = ladderInput.getHeight();
            ladderInput.flush();
        } while (!ladderInput.checkValid(nameArr, destination, ladderHeight));

        ladderOutput.sendOutputObject(new LadderGame(ladderHeight, destination, nameArr));
    }
}