package common.practice.collections;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Accountant {

    public static Integer calculateSum(List<Integer> values) {
        return values.stream()
                .reduce(0, (a, b) -> a + b);
    }

    public static List<Integer> convertToList(List<List<Integer>> values) {
        return values.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
