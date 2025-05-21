package common.version.v17.jep356;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomGeneratorUtil {

    private static final String ALGORITHM_L32X64_MIX = "L32X64MixRandom";

    public static Integer getRandomNumber() {
        RandomGenerator randomGenerator = RandomGeneratorFactory.of(ALGORITHM_L32X64_MIX).create();
        return randomGenerator.nextInt(100);
    }
}
