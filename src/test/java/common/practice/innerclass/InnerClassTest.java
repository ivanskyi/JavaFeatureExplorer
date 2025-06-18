package common.practice.innerclass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InnerClassTest {

    @Test
    @DisplayName("Returns message from anonymous Device")
    void innerClassExecutesSuccessfully() {
        Laptop laptop = new Laptop();

        String result = laptop.invokeDevice(new Laptop.Cpu() {
            @Override
            public String start() {
                return "The device has started";
            }
        });

        assertEquals("The device has started", result);
    }
}
