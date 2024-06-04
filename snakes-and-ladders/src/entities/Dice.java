package entities;

import java.util.Random;

public class Dice {

    private final Random random = new Random();
    private int min, max;

    public Dice(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int roll() {
        return random.nextInt(max - min + 1) + min;
    }
}
