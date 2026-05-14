package practice.linear;

import java.util.Iterator;
import java.util.Objects;

public class OneWayLinkedList implements Iterable<String> {
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

    public void clear() {
        head = null;
        size = 0;
    }

    public int length() {
        return size;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("超出索引值");
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.item;
    }

    /**
     * 頭插
     */
    public void append(String item) {
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

    public void insert(int index, String item) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("超出索引值");
        }

        // 如果是頭節點
        if (index == 0) {
            head = new Node(item, head);
            size++;
            return;
        }

        // 找到前一個 node
        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }

        // 找到 index 的 node
        Node current = pre.next;

        // 指針轉換
        pre.next = new Node(item, current);

        size++;
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("超出索引值");
        }

        if (index == 0) {
            String result = head.item;
            head = head.next;
            size--;
            checkSize();
            return result;
        }

        // 找到前一個 node
        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }

        // 找到 index 的 node
        Node current = pre.next;

        // 指針轉換
        pre.next = pre.next.next;
        size--;
        checkSize();
        return current.item;
    }

    public int indexOf(String item) {
        Node node = head;
        for (int i = 0; i < size; i++) {
//            if (node.item == null) {
//                if (item == null) {
//                    return i;
//                }
//            } else {
//                if (node.item.equals(item)) {
//                    return i;
//                }
//            }

            // 以上的 if-else 可簡化成以下的寫法
            if (Objects.equals(node.item, item)) {
                return i;
            }

            node = node.next;
        }
        return -1;
    }

    /**
     * 單鏈表反轉，模擬雙鏈表的 pre 指針
     */
    public void reverseNode() {
        if (head == null) {
            return;
        }
        reverseNode(head);
    }

    private Node reverseNode(Node current) {
        if (current.next == null) {
            head = current;
            return current;
        }

        // 返回值是當前結點的上一個結點(已反轉)
        Node pre = reverseNode(current.next);

        // 返回結點的下一個結點是目前的結點
        pre.next = current;

        // 當前結點的下一個結點設為空
        current.next = null;
        return current;
    }

    private void checkSize() {
        if (size == 0) {
            clear();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {
        private Node node;

        public MyIterator() {
            this.node = head;
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
        OneWayLinkedList list = new OneWayLinkedList();
        list.append("a");
        list.append("b");
        list.append("d");
        System.out.println(list.get(2)); // d

        list.insert(2, null);

        // list.append(4, "c"); // 超出索引值

        System.out.println(list.remove(1)); // b

        System.out.println(list.indexOf("d")); // 2
        System.out.println(list.indexOf(null)); // 1

        list.insert(0, "xxx");
        System.out.println(list.remove(0));
        System.out.println("===========");
        for (int i = 0; i < list.size; i++) {
            System.out.println(list.get(i));
        }
        list.reverseNode();
        System.out.println("===========");
        for (int i = 0; i < list.size; i++) {
            System.out.println(list.get(i));
        }

        System.out.println("==============================");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
