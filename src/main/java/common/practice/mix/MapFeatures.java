package common.practice.mix;

import java.util.HashMap;
import java.util.Map;

public class MapFeatures {

    public static void main(String[] args) {
        Map<String, String> countryToCityMap = new HashMap<>();
        countryToCityMap.put("UA", "Lviv");
        countryToCityMap.put("USA", "Florida");

        String cityForUkraine = countryToCityMap.computeIfAbsent("UA", country -> "Kyiv");
        String cityForPoland = countryToCityMap.computeIfAbsent("PL", country -> "Warsaw");

        System.out.println("UA -> " + cityForUkraine);
        System.out.println("PL -> " + cityForPoland);
        System.out.println(countryToCityMap);
    }
}
