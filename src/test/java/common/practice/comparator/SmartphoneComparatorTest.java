package common.practice.comparator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartphoneComparatorTest {

    @Test
    @DisplayName("Sorts smartphones using SmartphoneComparator")
    void testSmartphoneSorting() {
        List<Smartphone> smartphones = new ArrayList<>(List.of(
                new Smartphone(784),
                new Smartphone(71),
                new Smartphone(2)
        ));

        smartphones.sort(new SmartphoneComparator());

        assertEquals(2, smartphones.get(0).getVersion());
        assertEquals(71, smartphones.get(1).getVersion());
        assertEquals(784, smartphones.get(2).getVersion());
    }
}
