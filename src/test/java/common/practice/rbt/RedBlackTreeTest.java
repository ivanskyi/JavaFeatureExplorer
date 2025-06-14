package common.practice.rbt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    @Test
    @DisplayName("Insert and get operations")
    void insertAndGetOperations() {
        RedBlackTree<String> tree = new RedBlackTree<>();

        tree.insert(10, "Hello");
        tree.insert(20, "Halo");
        tree.insert(30, "Привіт");

        Node<String> node10 = tree.get(10);
        Node<String> node20 = tree.get(20);
        Node<String> node30 = tree.get(30);
        Node<String> nodeNotFound = tree.get(40);

        assertNotNull(node10);
        assertEquals(10, node10.key);
        assertEquals("Hello", node10.getValue());

        assertNotNull(node20);
        assertEquals(20, node20.key);
        assertEquals("Halo", node20.getValue());

        assertNotNull(node30);
        assertEquals(30, node30.key);
        assertEquals("Привіт", node30.getValue());

        assertNull(nodeNotFound);
    }

    @Test
    @DisplayName("Root color is always black")
    void rootColorIsBlack() {
        RedBlackTree<String> tree = new RedBlackTree<>();

        tree.insert(10, "Test");
        Node<String> root = tree.get(10);

        assertFalse(root.color);
    }

    @Test
    @DisplayName("Empty tree returns null")
    void emptyTreeReturnsNull() {
        RedBlackTree<String> tree = new RedBlackTree<>();

        Node<String> result = tree.get(10);

        assertNull(result);
    }
}
