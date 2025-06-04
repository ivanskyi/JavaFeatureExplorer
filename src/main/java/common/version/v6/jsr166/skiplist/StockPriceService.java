package common.version.v6.jsr166.skiplist;

import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class StockPriceService {
    private static final long ONE_MINUTE_MILLIS = 60_000;

    private final ConcurrentSkipListMap<Long, Double> priceMap = new ConcurrentSkipListMap<>();

    public void updatePrice(long timestamp, double price) {
        priceMap.put(timestamp, price);
    }

    public Double getLatestPrice() {
        return priceMap.lastEntry() != null
                ? priceMap.lastEntry().getValue()
                : null;
    }

    public NavigableMap<Long, Double> getPricesInLastMinute(long currentTimestamp) {
        long oneMinuteAgo = currentTimestamp - ONE_MINUTE_MILLIS;
        return priceMap.subMap(oneMinuteAgo, true, currentTimestamp, true);
    }
}
