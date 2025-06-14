package common.practice.rbt;

public class RedBlackTree<T> {

    private Node<T> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public void insert(int key, T value) {
        Node<T> newNode = new Node<>(key, value);
        root = insertNode(root, newNode);
        fixRedBlackProperties(newNode);
    }

    private Node<T> insertNode(Node<T> currentRoot, Node<T> newNode) {
        if (currentRoot == null) {
            return newNode;
        }

        if (newNode.key < currentRoot.key) {
            currentRoot.left = insertNode(currentRoot.left, newNode);
            currentRoot.left.parent = currentRoot;
        } else if (newNode.key > currentRoot.key) {
            currentRoot.right = insertNode(currentRoot.right, newNode);
            currentRoot.right.parent = currentRoot;
        }

        return currentRoot;
    }

    private void fixRedBlackProperties(Node<T> node) {
        while (node != root && isRed(node) && isRed(node.parent)) {
            Node<T> parent = node.parent;
            Node<T> grandParent = parent.parent;

            if (parent == grandParent.left) {
                node = fixLeftSideViolation(node, parent, grandParent);
            } else {
                node = fixRightSideViolation(node, parent, grandParent);
            }
        }
        root.color = BLACK;
    }

    private Node<T> fixLeftSideViolation(Node<T> node, Node<T> parent, Node<T> grandParent) {
        Node<T> uncle = grandParent.right;

        if (isRed(uncle)) {
            return recolorNodes(node, parent, grandParent, uncle);
        } else {
            return rotateForLeftSide(node, parent, grandParent);
        }
    }

    private Node<T> fixRightSideViolation(Node<T> node, Node<T> parent, Node<T> grandParent) {
        Node<T> uncle = grandParent.left;

        if (isRed(uncle)) {
            return recolorNodes(node, parent, grandParent, uncle);
        } else {
            return rotateForRightSide(node, parent, grandParent);
        }
    }

    private Node<T> recolorNodes(Node<T> node, Node<T> parent, Node<T> grandParent, Node<T> uncle) {
        grandParent.color = RED;
        parent.color = BLACK;
        uncle.color = BLACK;
        return grandParent;
    }

    private Node<T> rotateForLeftSide(Node<T> node, Node<T> parent, Node<T> grandParent) {
        if (node == parent.right) {
            rotateLeft(parent);
            node = parent;
            parent = node.parent;
        }
        rotateRight(grandParent);
        swapColors(parent, grandParent);
        return parent;
    }

    private Node<T> rotateForRightSide(Node<T> node, Node<T> parent, Node<T> grandParent) {
        if (node == parent.left) {
            rotateRight(parent);
            node = parent;
            parent = node.parent;
        }
        rotateLeft(grandParent);
        swapColors(parent, grandParent);
        return parent;
    }

    private void swapColors(Node<T> node1, Node<T> node2) {
        boolean tempColor = node1.color;
        node1.color = node2.color;
        node2.color = tempColor;
    }

    private boolean isRed(Node<T> node) {
        return node != null && node.color == RED;
    }

    private void rotateLeft(Node<T> node) {
        Node<T> rightChild = node.right;

        node.right = rightChild.left;
        if (node.right != null) {
            node.right.parent = node;
        }

        rightChild.parent = node.parent;
        updateParentChild(node, rightChild);

        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(Node<T> node) {
        Node<T> leftChild = node.left;

        node.left = leftChild.right;
        if (node.left != null) {
            node.left.parent = node;
        }

        leftChild.parent = node.parent;
        updateParentChild(node, leftChild);

        leftChild.right = node;
        node.parent = leftChild;
    }

    private void updateParentChild(Node<T> oldChild, Node<T> newChild) {
        if (oldChild.parent == null) {
            root = newChild;
        } else if (oldChild == oldChild.parent.left) {
            oldChild.parent.left = newChild;
        } else {
            oldChild.parent.right = newChild;
        }
    }

    public Node<T> get(int key) {
        return findNode(root, key);
    }

    private Node<T> findNode(Node<T> currentNode, int key) {
        if (currentNode == null || currentNode.key == key) {
            return currentNode;
        }

        if (key < currentNode.key) {
            return findNode(currentNode.left, key);
        } else {
            return findNode(currentNode.right, key);
        }
    }
}
