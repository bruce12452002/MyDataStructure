package practice.linear;


import java.util.Iterator;
import java.util.Objects;

public class MapWithLinkedList implements Iterable<String> {
    protected Node head;
    protected int size;

    protected static class Node {
        protected final String key;
        protected String value;
        protected Node next;

        public Node(String key, String value, Node next) {
            this.key = key;
            this.value = value;
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
    public void put(String key, String value) {
        if (head == null) {
            head = new Node(key, value, null);
            size++;
            return;
        }

        // 有重覆的 key 就更新 value
        Node node = head;
        while (node != null) {
            if (Objects.equals(key, node.key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        head = new Node(key, value, head);
        size++;
    }

    public String remove(String key) {
        Node node = head;
        Node pre = null;
        while (node != null) {
            if (Objects.equals(key, node.key)) {
                if (pre == null) { // 如果是頭節點
                    head = head.next;
                    size--;
                    return node.value;
                }

                pre.next = node.next;
                size--;
                return node.value;
            }
            pre = node;
            node = node.next;
        }
        return null;
    }

    public String get(String key) {
        Node node = head;
        while (node != null) {
            if (Objects.equals(key, node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
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
            String result = node.value;
            node = node.next;
            return result;
        }
    }

    public static void main(String[] args) {
        MapWithLinkedList map = new MapWithLinkedList();
        map.put("a", "apple");
        map.put("b", "banana");
        System.out.println(map.get("b"));
        System.out.println(map.remove("a"));
        System.out.println("==========================");

        for (String str : map) {
            System.out.println(str);
        }
    }
}
