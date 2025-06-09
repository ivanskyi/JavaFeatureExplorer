package common.practice.rbt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    @Test
    @DisplayName("Insert and get")
    void insertAndGet() {
        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(10);
        redBlackTree.insert(20);
        redBlackTree.insert(30);
        redBlackTree.insert(15);

        Node node10 = redBlackTree.get(10);
        Node node20 = redBlackTree.get(20);
        Node node30 = redBlackTree.get(30);
        Node node15 = redBlackTree.get(15);
        Node node40 = redBlackTree.get(40);

        assertNotNull(node10);
        assertEquals(10, node10.key);

        assertNotNull(node20);
        assertEquals(20, node20.key);

        assertNotNull(node30);
        assertEquals(30, node30.key);

        assertNotNull(node15);
        assertEquals(15, node15.key);

        assertNull(node40);
    }
}
