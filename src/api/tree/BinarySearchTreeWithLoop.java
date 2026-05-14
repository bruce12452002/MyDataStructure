package api.tree;

/**
 * 二元搜尋樹
 * 對於根節點，左子樹中所有節點的值 < 根節點的值 < 右子樹中所有節點的值 (PS 全部都 > 也可以)
 * 任意節點的左、右子樹也是二元搜尋樹，也就是同樣滿足上一行的條件
 */
public class BinarySearchTreeWithLoop {
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
    }

    public boolean isEmpty() {
        return false;
    }

    public int length() {
        return -1;
    }

    public void add(int key, String value) {
    }

    public String get(int key) {
        return null;
    }

    public void remove(int key) {
    }

    public Node getMinKey() {
        return null;
    }

    public Node getMaxKey() {
        return null;
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
        BinarySearchTreeWithLoop tree = new BinarySearchTreeWithLoop();
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
