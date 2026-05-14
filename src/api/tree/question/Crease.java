package api.tree.question;

import practice.linear.ArrayList2;

/**
 * 一張紙由右往左摺，每次都由右往左摺，每次都會留下凹凸的摺痕
 * 以三摺為例，凹以 D 代替；凸以 U 代替，結果為 DDUDDUU，是中序𨖠歷，長如下的樣子
 *
 *           D
 *        /    \
 *       D      U
 *      / \   /  \
 *     D  U  D   U
 * 每摺一次都是 perfect 二元樹，節點樹是 (2^n)-1
 * 每往下一層都是 左 D 右 U
 */
public class Crease {
    private static class Node<T> {
        private T item;
        private Node<T> left;
        private Node<T> right;

        public Node(T item, Node<T> left, Node<T> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 產生 perfect binary tree
     *
     * @param count 表示摺幾次
     * @return 建好的樹
     */
    public static Node<String> createTree(int count) {
        return null;
    }

    public static void printTree(Node<String> root, ArrayList2 result) {
    }

    public static void main(String[] args) {
        Node<String> tree = createTree(3);
        ArrayList2 list = new ArrayList2(10);
        printTree(tree, list);
        list.forEach(System.out::println);
    }
}
