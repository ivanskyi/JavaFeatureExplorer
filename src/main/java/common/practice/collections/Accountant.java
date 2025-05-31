package common.practice.collections;

import java.util.List;

public class Accountant {

    public static Integer calculateSum(List<Integer> values) {
        return values.stream()
                .reduce(0, (a, b) -> a + b);
    }
}
