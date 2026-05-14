package practice.linear;

import java.util.Iterator;

/**
 * 單向串列用尾取比較麻煩，因為要改變尾節點時，要取得尾節點的上一個節點，只能從頭節點遍歷
 */
public class QueueWithLinkedList<T> implements Iterable<T> {
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
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 尾插
     */
    public void enqueue(T item) {
        if (head == null) {
            head = new Node(item, null);
            size++;
            return;
        }

        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(item, null);
        size++;
    }

    /**
     * 頭取
     */
    public T dequeue() {
        if (head == null) {
            return null;
        }
        T result = head.item;
        head = head.next;
        size--;
        return result;
    }

    public T peek() {
        return head == null ? null : head.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node node;

        public MyIterator() {
            node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T result = node.item;
            node = node.next;
            return result;
        }
    }

    public static void main(String[] args) {
        QueueWithLinkedList<String> queue = new QueueWithLinkedList<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println("=====================");
        queue.forEach(System.out::println);
    }
}
