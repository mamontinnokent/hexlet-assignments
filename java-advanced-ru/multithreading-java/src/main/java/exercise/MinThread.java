package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private final int[] array;
    private int min;

    public int getMin() {
        return min;
    }

    public MinThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        min = Arrays.stream(array)
                .min()
                .orElseThrow();
    }
}
// END
