package api.linear;

/**
 * 單向串列用尾取比較麻煩，因為要改變尾節點時，要取得尾節點的上一個節點，只能從頭節點遍歷
 */
public class QueueWithLinkedList<T> {
    private Node head;
    private int size;

    private class Node {
        private final T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public int length() {
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public void enqueue(T item) {
    }

    public T dequeue() {
        return null;
    }

    public T peek() {
        return null;
    }

    public static void main(String[] args) {
    }
}
