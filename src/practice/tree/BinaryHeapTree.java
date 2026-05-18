package practice.tree;


/**
 * HeapTree (堆積樹)：是一個 Complete Binary Tree，所以用陣列來實作會比串列來的效率高
 * 每個節點都 <= 或 >= 它的兩個子節點 (小頂堆積或大頂堆積)，但這兩個子節點的順序沒有規定
 *
 * min heap (小頂堆積)：任意節點的值 <= 其子節點的值，目的是「動態」取得最小值
 * max heap (大頂堆積)：任意節點的值 >= 其子節點的值，目的是「動態」取得最大值，如下圖
 *
 * 堆積樹的重點在取得最大或最小，其他功能的時間複雜度沒那麼好
 *
 *
 * PS 使用 a-z 來比較大小，用數字怕和索引搞混，增加學習的困難
 *                i
 *            /       \
 *           h        f
 *         /  \      /  \
 *        f    g    f    b
 *       / \  / \  /
 *      c  e b  d  a
 *
 *   索引  0 1 2 3 4 5 6 7 8 9 10 11
 *   元素  i h f f g f b c e b d  a
 *   父節點： (i-1) / 2
 *   子節點： 2i+1  2i+2
 */
public class BinaryHeapTree {
    protected String[] elements; // 使用 a-z 來比較大小，用數字怕和索引搞混，增加學習的困難

    protected int size;

    public BinaryHeapTree() {
        elements = new String[20];
    }

    private boolean compare(int index, int index2) {
        // > 就是 max heap (大頂堆積)； < 就是 min heap (小頂堆積)
        return elements[index].compareTo(elements[index2]) > 0;
    }

    protected void exchange(int index, int index2) {
        String temp = elements[index];
        elements[index] = elements[index2];
        elements[index2] = temp;
    }

    private int getLeftNode(int index) {
        return 2 * index + 1;
    }

    private int getRightNode(int index) {
        return 2 * index + 2;
    }

    private int getParentNode(int index) {
        return (index - 1) / 2;
    }

    public void add(String value) {
        // 擴容
        if (size == elements.length) {
            String[] newArray = new String[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }

        elements[size] = value;
        siftUp(size);
        size++;
    }

    private void siftUp(int index) {
        while (index > 0) { // 目前索引必需 > 0
            final int parent = getParentNode(index);
            if (compare(index, parent)) {
                exchange(index, parent);
                index = parent; // 交換索引，父類如果還有父類還得一層一層往上交換
            } else {
                break;
            }
        }
    }

    protected void siftDown(int index) {
        while (true) {
            int left = getLeftNode(index);
            int right = getRightNode(index);
            int temp = index;

            if (left < size && compare(left, temp)) {
                temp = left;
            }

            if (right < size && compare(right, temp)) {
                temp = right;
            }

            // temp 索引沒變，表示已經符合 Heap Tree
            if (temp == index) {
                break;
            }

            exchange(index, temp);
            index = temp;
        }
    }

    public String removeRoot() {
        if (size == 0) return null;

        String result = elements[0];
        elements[0] = elements[size - 1]; // 最後一個放到根
        elements[size - 1] = null; // 刪除
        size--;
        if (size > 0) {
            siftDown(0);
        }
        return result;
    }

    /**
     * 刪除第一個遇到的 value
     */
    public boolean remove(String value) {
        if (size == 0) return false;

        // 找元素索引
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                index = i;
                break;
            }
        }

        // 找不到
        if (index == -1) {
            return false;
        }

        if (index == 0) {
            removeRoot();
            return true;
        }

        // 最後一個元素覆蓋
        elements[index] = elements[size - 1];
        elements[size - 1] = null;
        size--;

        // 如果刪的是最後一個
        if (index == size) {
            return true;
        }

        // 判斷要上浮還是下沉
        if (compare(index, getParentNode(index))) {
            siftUp(index);
        } else {
            siftDown(index);
        }

        return true;
    }

    /**
     * 樹化成堆積樹，陣列是亂的也沒關係
     */
    public void heapify() {
        // 從最後一個非葉節點開始，所以是 size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public static void main(String[] args) {
        BinaryHeapTree tree = new BinaryHeapTree();
        tree.add("c");
        tree.add("d");
        tree.add("a");
        tree.add("f");
        tree.add("e");
        tree.add("b");

        tree.add("i");
        tree.add("f");
        tree.add("h");
        tree.add("b");
        tree.add("g");
        tree.add("f");

        System.out.println(tree.removeRoot());
    }
}
