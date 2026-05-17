package api.tree;

import api.linear.QueueWithLinkedList;
import api.linear.ArrayList2;

/**
 * 二元搜尋樹
 * 對於根節點，左子樹中所有節點的值 < 根節點的值 < 右子樹中所有節點的值 (PS 全部都 > 也可以)
 * 任意節點的左、右子樹也是二元搜尋樹，也就是同樣滿足上一行的條件
 *
 * 使用串列來實作，因為使用陣列實作時，二元搜尋樹並不是 Complete Binary Tree，所以有些值會存 null，造成空間浪費
 */
public class BinarySearchTreeWithRecursive {
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

    private Node add(Node node, int key, String value) {
        return null;
    }

    public String get(int key) {
        return null;
    }

    private String get(Node node, int key) {
        return null;
    }

    public void remove(int key) {
    }

    private Node remove(Node node, int key) {
        return null;
    }

    public Node getMinKey() {
        return null;
    }

    private Node getMinKey(Node node) {
        return null;
    }

    public Node getMaxKey() {
        return null;
    }

    private Node getMaxKey(Node node) {
        return null;
    }

    public QueueWithLinkedList<Integer> preOrder() {
        return null;
    }

    /**
     * 前序：中左右(子樹)
     */
    private void preOrder(Node node, QueueWithLinkedList<Integer> keys) {
    }

    public QueueWithLinkedList<Integer> inOrder() {
        return null;
    }

    /**
     * 中序：左中右(子樹)
     */
    private void inOrder(Node node, QueueWithLinkedList<Integer> keys) {
    }

    public QueueWithLinkedList<Integer> postOrder() {
        return null;
    }

    /**
     * 後序：左右中(子樹)
     */
    private void postOrder(Node node, QueueWithLinkedList<Integer> keys) {
    }

    /**
     * 層級遍歷：由上而下，由左至右，也就是中左右
     */
    public ArrayList2 levelOrder() {
        return null;
    }

    public int maxDepth() {
        return -1;
    }

    private int maxDepth(Node node) {
        return -1;
    }

    /**
     *                       10
     *                  /         \
     *                 5          21
     *               /   \      /    \
     *              3     9    13     28
     *             / \          \    /  \
     *            1  4          17  23  32
     *
     *            前序： 10,5,3,1,4,9,21,13,17,28,23,32
     *            中序： 1,3,4,5,9,10,13,17,21,23,28,32
     *            後序： 1,4,3,9,5,17,13,23,32,28,21,10
     *            層級： 10,5,21,3,9,13,28,1,4,17,23,32
     */
    public static void main(String[] args) {
        BinarySearchTreeWithRecursive tree = new BinarySearchTreeWithRecursive();
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
    }
}
