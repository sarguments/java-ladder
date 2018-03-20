package saru.domain;

import java.util.Random;

public class LadderPointGenerator {
    private static Random random = new Random();

    private LadderPointGenerator() {
    }

    public static boolean generateRandPoint() {
        return random.nextBoolean();
    }
}
