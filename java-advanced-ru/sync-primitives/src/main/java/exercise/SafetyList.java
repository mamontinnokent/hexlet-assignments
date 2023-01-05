package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    // BEGIN
    private final List<Integer> list = new ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public synchronized boolean add(Integer integer) {
        return list.add(integer);
    }

    public Integer get(int index) {
        return list.get(index);
    }

    // END
}
