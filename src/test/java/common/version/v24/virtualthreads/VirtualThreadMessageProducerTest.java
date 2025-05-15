package common.version.v24.virtualthreads;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualThreadMessageProducerTest {

    @Test
    @DisplayName("All virtual threads complete before method returns")
    void shouldCollectMessagesFromAllVirtualThreads() {
        VirtualThreadMessageProducer virtualThreadMessageProducer = new VirtualThreadMessageProducer();
        assertEquals(1000, virtualThreadMessageProducer.getQueueWithMessages().size());
    }
}
