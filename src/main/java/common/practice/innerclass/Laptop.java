package common.practice.innerclass;

public class Laptop {

    interface Cpu {
        String start();
    }

    public String invokeDevice(Cpu CPU) {
        return CPU.start();
    }
}
