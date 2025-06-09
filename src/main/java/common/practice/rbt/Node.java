package common.practice.rbt;

public class Node {

    int key;
    Node left, right, parent;
    boolean color;

    public Node(int key) {
        this.key = key;
        this.color = true;
        left = right = parent = null;
    }
}
