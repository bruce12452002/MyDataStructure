package api.tree;



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
public class HeapTree {
    protected String[] elements; // 使用 a-z 來比較大小，用數字怕和索引搞混，增加學習的困難

    protected int size;

    public HeapTree() {
    }

    private boolean compare(int index, int index2) {
        return false;
    }

    protected void exchange(int index, int index2) {
    }

    private int getLeftNode(int index) {
        return -1;
    }

    private int getRightNode(int index) {
        return -1;
    }

    private int getParentNode(int index) {
        return -1;
    }

    public void add(String value) {
    }

    private void siftUp(int index) {
    }

    protected void siftDown(int index) {
    }

    public String removeRoot() {
        return null;
    }

    /**
     * 刪除第一個遇到的 value
     */
    public boolean remove(String value) {
        return false;
    }

    public static void main(String[] args) {
        HeapTree tree = new HeapTree();
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
    }
}
