package common.practice.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountantTest {

    private final List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    @DisplayName("Sum")
    void sum() {
        Integer result = Accountant.calculateSum(values);
        assertEquals(15, result);
    }
}
