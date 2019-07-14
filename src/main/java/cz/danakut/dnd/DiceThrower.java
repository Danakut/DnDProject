package cz.danakut.dnd;

import java.util.Random;

public class DiceThrower {

    private Random rng;

    DiceThrower() {
        rng = new Random();
    }

    public int makeRoll(int diceSides, int numberOfDice, int modifier) {
        int sum = 0;
        for (int i = 0; i < numberOfDice ; i++) {
            int throwResult = makeAThrow(diceSides);
            sum += throwResult;
        }

        sum += modifier;
        return sum;
    }

    private int makeAThrow(int diceSides) {
        return rng.nextInt(diceSides) + 1;
    }
}
