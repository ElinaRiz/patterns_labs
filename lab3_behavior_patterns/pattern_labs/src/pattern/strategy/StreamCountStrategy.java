package pattern.strategy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCountStrategy implements CountStrategy {
    public Map<Integer, Integer> count(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(v -> 1)));
    }
}