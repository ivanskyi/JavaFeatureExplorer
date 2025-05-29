package common.practice.comparator;

public class Smartphone {

    private int version;

    public Smartphone(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "version=" + version +
                '}';
    }
}
