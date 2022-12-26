package model.generator;
import java.util.Random;

public class posIntGenerator implements Generator{
    private Random random = new Random();

    public posIntGenerator() {}

    @Override
    public int[] generate(int num) {
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            int integer = random.nextInt(20 - 1 + 1) + 1;
            array[i] = integer;
        }

        return array;
    }
}
