package model.generator;

import java.util.Random;

public class negPosIntGenerator implements Generator {
    private int[] array;
    private Random random = new Random();

    public negPosIntGenerator() {}

    @Override
    public int[] generate(int num) {
        int[] newArray = new int[num];
        for (int i = 0; i < newArray.length; i++) {
            int rand = random.nextInt(50 + 50) - 50;
            newArray[i] = rand;
        }
        this.array = newArray;

        return newArray;
    }

    public int[] getArray() {
        return array;
    }
}
