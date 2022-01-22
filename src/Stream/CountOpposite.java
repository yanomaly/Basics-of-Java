package Stream;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CountOpposite {
    public int count(ArrayList<Integer> numbers){
        return numbers.stream().filter(x -> numbers.stream().anyMatch(y -> y == -x)).filter(x -> x != 0).collect(Collectors.toMap(x -> x, x -> 1, (x, y) -> x + y))
                .entrySet().stream().collect(Collectors.toMap(x -> Math.abs(x.getKey()), x -> x.getValue(), (x, y) -> x > y ? y : x))
                .values().stream().mapToInt(Integer::intValue).sum();
    }
}
