package practice.linear;

import java.util.Iterator;

/**
 * 單向串列用尾取比較麻煩，因為要改變尾節點時，要取得尾結點的上一個節點，只能從頭節點遍歷
 */
public class StackWithLinkedList implements Iterable<String> {
    private Node head;
    private int size;

    private static class Node {
        private final String item;
        private Node next;

        public Node(String item, Node next) {
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
     * 頭插
     */
    public void push(String item) {
        size++;
        if (head == null) {
            head = new Node(item, null);
            return;
        }

        head = new Node(item, head);

    }

    /**
     * 頭取
     */
    public String pop() {
        if (head == null) {
            return null;
        }

        String result = head.item;
        head = head.next;
        size--;
        return result;
    }

    /**
     * 偷看最後一個元素
     */
    public String peek() {
        if (head == null) {
            return null;
        }
        return head.item;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {
        private Node node;

        public MyIterator() {
            node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public String next() {
            String result = node.item;
            node = node.next;
            return result;
        }
    }

    public static void main(String[] args) {
        StackWithLinkedList stack = new StackWithLinkedList();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
