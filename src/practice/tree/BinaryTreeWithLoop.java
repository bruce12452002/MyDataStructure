package practice.tree;

public class BinaryTreeWithLoop {
    private Node root;
    private int size;

    private static class Node {
        private int key;
        private String value;
        private Node left;
        private Node right;

        public Node(int key, String value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {
        return size;
    }

    public void add(int key, String value) {
        if (root == null) {
            root = new Node(key, value, null, null);
            size++;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current; // 利用 parent 儲存上一個節點

            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                // key 已存在，更新 value
                current.value = value;
                return;
            }
        }

        // 插入新節點
        Node newNode = new Node(key, value, null, null);
        if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        size++;
    }

    public String get(int key) {
        Node current = root;

        while (current != null) {
            if (key > current.key) {
                current = current.right;
            } else if (key < current.key) {
                current = current.left;
            } else {
                return current.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        Node current = root;
        Node parent = null;

        // 找到要刪除的節點
        while (current != null && current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) return; // 沒找到直接 return

        // 如果有兩個子節點，這裡用「找右子樹最小節點」
        if (current.left != null && current.right != null) {
            Node successorParent = current;
            Node minNode = current.right; // 找右子樹最小節點

            while (minNode.left != null) {
                successorParent = minNode;
                minNode = minNode.left;
            }

            // 將右子樹最小節點的 key value 都賦值給 current
            current.key = minNode.key;
            current.value = minNode.value;

            // 接下來刪掉 minNode（最多只有一個子節點）
            parent = successorParent;
            current = minNode;
        }

        Node node;
        if (current.left != null) {
            node = current.left; // 只有右子樹沒有時
        } else {
            node = current.right; // 只有左子樹沒有時
        }

        // 接回父節點
        if (parent == null) {
            root = node; // 如果刪除的是 root
        } else if (parent.left == current) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        size--;
    }

    public Node getMinKey() {
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node getMaxKey() {
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     *                       10
     *                  /         \
     *                 5          21
     *               /   \      /    \
     *              3     9    13     28
     *             / \          \    /  \
     *            1  4          17  23  32
     */
    public static void main(String[] args) {
        BinaryTreeWithLoop tree = new BinaryTreeWithLoop();
        tree.add(10, "xxx");
        tree.add(21, "b");
        tree.add(5, "c");
        tree.add(9, "d");
        tree.add(13, "e");
        tree.add(28, "f");
        tree.add(3, "g");
        tree.add(1, "h");
        tree.add(4, "i");
        tree.add(17, "j");
        tree.add(32, "k");
        tree.add(23, "l");

//        tree.add(10, "a");
//        tree.remove(21);
        System.out.println(tree.getMaxKey().key);
        System.out.println(tree);
    }
}
