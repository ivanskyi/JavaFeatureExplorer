package common.practice.async;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {

    @Test
    @DisplayName("Load greeting successfully")
    void loadGreeting() {
        MessageService messageService = new MessageService();
        String greeting = messageService.loadGreeting();
        assertEquals("Hello", greeting);
    }
}
