package pattern.strategy;

import java.util.Map;

public class CountContext {
    private CountStrategy strategy = new HashMapCountStrategy();

    public void setStrategy(CountStrategy strategy) {
        this.strategy = strategy;
    }

    public Map<Integer, Integer> executeStrategy(int[] array) {
        return strategy.count(array);
    }
}