package saru.domain;

import java.util.*;

public class LadderGame {
    private List<String> names = new ArrayList<>();
    private List<String> destinations = new ArrayList<>();
    private List<LadderLine> lines = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();

    public LadderGame(int ladderHeight, String[] destination, String[] nameArr) {
        inputDestination(destination);
        inputNames(nameArr);

        initLines(nameArr.length, ladderHeight);

        // 실행
        this.run();
    }

    private void inputNames(String[] nameArr) {
        names.addAll(Arrays.asList(nameArr));
    }

    private void inputDestination(String[] destination) {
        destinations.addAll(Arrays.asList(destination));
    }

    private void initLines(int userNum, int lineNum) {
        for (int i = 0; i < lineNum; i++) {
            lines.add(LadderLine.init(userNum));
        }
    }

    private int getMovedIndex(List<LadderLine> lines, int movedIndex) {
        for (LadderLine line : lines) {
            movedIndex = line.move(movedIndex);
        }
        return movedIndex;
    }

    private void run() {
        for (int i = 0; i < names.size(); i++) {
            int movedIndex = getMovedIndex(lines, i);
            result.add(movedIndex);
        }
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getDestination() {
        return destinations;
    }

    public List<LadderLine> getLines() {
        return lines;
    }

    public List<Integer> getResult() {
        return result;
    }
}