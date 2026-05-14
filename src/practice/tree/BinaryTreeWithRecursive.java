package practice.tree;

import practice.linear.ArrayList2;
import practice.linear.QueueWithLinkedList;

public class BinaryTreeWithRecursive {
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
        root = add(root, key, value);
    }

    private Node add(Node node, int key, String value) {
        if (node == null) {
            size++;
            return new Node(key, value, null, null);
        }

        if (key < node.key) {
            // 左子樹
            node.left = add(node.left, key, value);
        } else if (key > node.key) {
            // 右子樹
            node.right = add(node.right, key, value);
        } else {
            // key 已存在，更新 value
            node.value = value;
        }
        return node;
    }

    public String get(int key) {
        return get(root, key);
    }

    private String get(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            return get(node.left, key);
        } else if (key > node.key) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    private Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            // 左右子樹都沒有時，直接刪除
            // 此 if 可省略，因為用下面兩個 if 時，回傳的不管是 node.left 還是 node.right 都是 null
//            if (node.right == null && node.left == null) {
//                size--;
//                return null;
//            }

            // 只有右子樹沒有時
            if (node.right == null) {
                size--;
                return node.left;
            }

            // 只有左子樹沒有時
            if (node.left == null) {
                size--;
                return node.right;
            }

            // 左右子樹都有時，找到「右子樹中最小的節點」或者找到「左子樹中最大的節點」，使用其中一個就行


            // =========================================== 右子樹中最小的節點 ===========================================
            // 找右子樹最小節點
            Node minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            // 增加新節點的左右子樹
            minNode.left = node.left; // 要刪除的左節點為新節點的左節點
            minNode.right = remove(node.right, minNode.key); // 將 node.right 子樹裡，指定 key 的節點刪除，並回傳 node.right

            return minNode; // 回傳新節點


            // ============================================= 左子樹中最大的節點 ===========================================
            // 找左子樹最大節點
//            Node maxNode = node.left;
//            while (maxNode.right != null) {
//                maxNode = minNode.right;
//            }
//
//            // 增加新節點的左右子樹
//            maxNode.left = remove(node.left, maxNode.key); // 將 node.left 子樹裡，指定 key 的節點刪除，並回傳 node.left
//            maxNode.right = node.right; // 要刪除的右節點為新節點的商節點
//
//            return maxNode; // 回傳新節點
        }
        return node;
    }

    public Node getMinKey() {
        return getMinKey(root);
    }

    private Node getMinKey(Node node) {
        if (node.left != null) {
            return getMinKey(node.left);
        }
        return node;
    }

    public Node getMaxKey() {
        return getMaxKey(root);
    }

    private Node getMaxKey(Node node) {
        if (node.right != null) {
            return getMaxKey(node.right);
        }
        return node;
    }

    public QueueWithLinkedList<Integer> preOrder() {
        QueueWithLinkedList<Integer> keys = new QueueWithLinkedList<>();
        preOrder(root, keys);
        return keys;
    }

    /**
     * 前序：中左右(子樹)
     */
    private void preOrder(Node node, QueueWithLinkedList<Integer> keys) {
        if (node == null) return;

        keys.enqueue(node.key);

        if (node.left != null) {
            preOrder(node.left, keys);
        }

        if (node.right != null) {
            preOrder(node.right, keys);
        }
    }

    public QueueWithLinkedList<Integer> inOrder() {
        QueueWithLinkedList<Integer> keys = new QueueWithLinkedList<>();
        inOrder(root, keys);
        return keys;
    }

    /**
     * 中序：左中右(子樹)
     */
    private void inOrder(Node node, QueueWithLinkedList<Integer> keys) {
        if (node == null) return;

        if (node.left != null) {
            inOrder(node.left, keys);
        }

        keys.enqueue(node.key);

        if (node.right != null) {
            inOrder(node.right, keys);
        }
    }

    public QueueWithLinkedList<Integer> postOrder() {
        QueueWithLinkedList<Integer> keys = new QueueWithLinkedList<>();
        postOrder(root, keys);
        return keys;
    }

    /**
     * 後序：左右中(子樹)
     */
    private void postOrder(Node node, QueueWithLinkedList<Integer> keys) {
        if (node == null) return;

        if (node.left != null) {
            postOrder(node.left, keys);
        }

        if (node.right != null) {
            postOrder(node.right, keys);
        }

        keys.enqueue(node.key);
    }

    /**
     * 層級遍歷：由上而下，由左至右，也就是中左右
     */
    public ArrayList2 levelOrder() {
        ArrayList2 result = new ArrayList2(10);
        if (root == null) return result;

        QueueWithLinkedList<Node> queue = new QueueWithLinkedList<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            // 將佇列彈出一個節點放入 list
            Node n = queue.dequeue();
            result.append(String.valueOf(n.key));

            if (n.left != null) {
                queue.enqueue(n.left);
            }

            if (n.right != null) {
                queue.enqueue(n.right);
            }
        }
        return result;
    }

    public int maxDepth() {
        return root == null ? 0 : maxDepth(root);
    }

    private int maxDepth(Node node) {
        int maxLeft = 0;
        int maxRight = 0;

        // 左子樹最大深度
        if (node.left != null) {
            maxLeft = maxDepth(node.left);
        }

        // 右子樹最大深度
        if (node.right != null) {
            maxRight = maxDepth(node.right);
        }

        // 左右子樹取最大深度，再加 1，表示把目前節點這一層算進去
        return (maxLeft > maxRight ? maxLeft : maxRight) + 1;
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
        BinaryTreeWithRecursive tree = new BinaryTreeWithRecursive();
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
//        System.out.println(tree.getMaxKey().key);

        QueueWithLinkedList<Integer> queue = tree.inOrder();
        queue.forEach(c -> System.out.print(c + ","));
//        ArrayList2 list = tree.levelOrder();
//        list.forEach(c -> System.out.print(c + ","));

//        System.out.println(tree.maxDepth());
    }
}
