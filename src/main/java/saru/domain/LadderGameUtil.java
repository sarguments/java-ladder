package saru.domain;

import java.util.Random;

class LadderGameUtil {
    private static final Random random = new Random();

    private LadderGameUtil() {
    }

    public static int getRand(int limit) {
        return random.nextInt(limit);
    }
}
