package common.practice.async;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {

    @Test
    @DisplayName("Get greeting using runAsync()")
    void getGreetingUsingRunAsync() {
        MessageService messageService = new MessageService();
        String greeting = messageService.getGreetingUsingRunAsync();
        assertEquals("Hello from async greeting loader", greeting);
    }

    @Test
    @DisplayName("Load greeting using supplyAsync")
    void getGreetingUsingSupplyAsync() {
        MessageService messageService = new MessageService();
        String greeting = messageService.getGreetingUsingSupplyAsync();
        assertEquals("Hello", greeting);
    }

    @Test
    @DisplayName("Get greeting using thenApply()")
    void getGreetingUsingThenApply() {
        MessageService messageService = new MessageService();
        String greeting = messageService.getGreetingUsingThenApply();
        assertEquals("Hello Developer", greeting);
    }

    @Test
    @DisplayName("Get greeting using thenAccept()")
    void getGreetingUsingThenAccept() {
        MessageService messageService = new MessageService();
        String greeting = messageService.getGreetingUsingThenAccept();
        assertEquals("Hello", greeting);
    }
}
