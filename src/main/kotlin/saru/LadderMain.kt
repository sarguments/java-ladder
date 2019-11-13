package saru;

import saru.domain.LadderGame;
import saru.view.LadderInput;
import saru.view.LadderOutput;

class LadderMain {
    private static final LadderInput ladderInput = new LadderInput();
    private static final LadderOutput ladderOutput = new LadderOutput();

    public static void main(String[] args) {
        String[] nameArr;
        String[] destination;
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
