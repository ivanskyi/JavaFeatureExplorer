package common.practice.comparator;

import java.util.Comparator;

public class SmartphoneComparator implements Comparator<Smartphone> {

    @Override
    public int compare(Smartphone firstSmartphone, Smartphone secondSmartphone) {
        return Integer.compare(firstSmartphone.getVersion(), secondSmartphone.getVersion());
    }
}
