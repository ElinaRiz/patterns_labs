package pattern.strategy;

import java.util.HashMap;
import java.util.Map;

public class HashMapCountStrategy implements CountStrategy {
    public Map<Integer, Integer> count(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int value : array) {
            result.put(value, result.getOrDefault(value, 0) + 1);
        }
        return result;
    }
}