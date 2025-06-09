package common.practice.rbt;

public class RedBlackTree {

    private Node root;
    private final boolean RED = true;
    private final boolean BLACK = false;

    public void insert(int key) {
        Node node = new Node(key);
        root = bstInsert(root, node);
        fixViolation(node);
    }

    private Node bstInsert(Node root, Node node) {
        if (root == null) {
            return node;
        }

        if (node.key < root.key) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (node.key > root.key) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }

        return root;
    }

    private void fixViolation(Node node) {
        Node parent = null;
        Node grandParent = null;

        while (node != root && node.color == RED && node.parent.color == RED) {
            parent = node.parent;
            grandParent = parent.parent;

            if (parent == grandParent.left) {
                Node uncle = grandParent.right;

                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.right) {
                        leftRotate(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    rightRotate(grandParent);
                    boolean t = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = t;
                    node = parent;
                }
            } else {
                Node uncle = grandParent.left;

                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.left) {
                        rightRotate(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    leftRotate(grandParent);
                    boolean t = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = t;
                    node = parent;
                }
            }
        }
        root.color = BLACK;
    }

    private void leftRotate(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;

        if (node.right != null)
            node.right.parent = node;

        rightChild.parent = node.parent;

        if (node.parent == null)
            root = rightChild;
        else if (node == node.parent.left)
            node.parent.left = rightChild;
        else
            node.parent.right = rightChild;

        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rightRotate(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;

        if (node.left != null)
            node.left.parent = node;

        leftChild.parent = node.parent;

        if (node.parent == null)
            root = leftChild;
        else if (node == node.parent.left)
            node.parent.left = leftChild;
        else
            node.parent.right = leftChild;

        leftChild.right = node;
        node.parent = leftChild;
    }

    public Node get(int key) {
        return search(root, key);
    }

    private Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
}
