package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread{
    private final int[] array;

    public int getMax() {
        return max;
    }

    private int max;


    public MaxThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        max = Arrays.stream(array)
                .max()
                .orElseThrow();
    }
}
// END
