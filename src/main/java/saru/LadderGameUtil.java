package saru;

import java.util.Random;

public class LadderGameUtil {
    private LadderGameUtil() {
    }

    private static Random random = new Random();

    public static int getRand(int limit) {
        return random.nextInt(limit);
    }
}
