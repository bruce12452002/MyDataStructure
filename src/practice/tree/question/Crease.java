package practice.tree.question;

import practice.linear.ArrayList2;
import practice.linear.QueueWithLinkedList;

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
    private static Node<String> createTree(int count) {
        Node<String> root = null;
        for (int i=0; i < count; i++) {
            if (i == 0) { // 第一摺
                root = new Node<>("D", null, null);
                continue;
            }

            QueueWithLinkedList<Node<String>> queue = new QueueWithLinkedList<>();
            queue.enqueue(root);

            while (!queue.isEmpty()) {
                Node<String> node = queue.dequeue();

                if (node.left != null) {
                    queue.enqueue(node.left);
                }

                if (node.right != null) {
                    queue.enqueue(node.right);
                }

                // 左右節點都沒有就是葉子節點
                if (node.left == null && node.right == null) {
                    node.left = new Node<>("D", null, null);
                    node.right = new Node<>("U", null, null);
                }
            }
        }
        return root;
    }

    private static void printTree(Node<String> root, ArrayList2 result) {
        if (root == null) return;

        if (root.left != null) {
            printTree(root.left, result);
        }

        result.append(root.item);

        if (root.right != null) {
            printTree(root.right, result);
        }
    }

    public static void main(String[] args) {
        Node<String> tree = createTree(3);
        ArrayList2 list = new ArrayList2(10);
        printTree(tree, list);
        list.forEach(System.out::println);
    }
}
