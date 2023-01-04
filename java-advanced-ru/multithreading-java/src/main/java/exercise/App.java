package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread maxThread = new MaxThread(numbers);
        maxThread.start();

        MinThread minThread = new MinThread(numbers);
        minThread.start();

        Map<String, Integer> map = new HashMap<>();
        try {
            maxThread.join();
            map.put("max", maxThread.getMax());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            minThread.join();
            map.put("min", minThread.getMin());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    // BEGIN
    
    // END
}
