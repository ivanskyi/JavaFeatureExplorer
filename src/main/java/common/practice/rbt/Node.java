package common.practice.rbt;

public class Node<T> {

    int key;
    T value;
    Node<T> left, right, parent;
    boolean color;

    public Node(int key, T value) {
        this.key = key;
        this.value = value;
        this.color = true;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public T getValue() {
        return value;
    }
}
