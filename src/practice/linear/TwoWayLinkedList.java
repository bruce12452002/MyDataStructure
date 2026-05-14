package practice.linear;

import java.util.Iterator;
import java.util.Objects;

public class TwoWayLinkedList implements Iterable<String> {
    private Node first;
    private Node last;
    private int size;

    private static class Node {
        private final String item;
        private Node pre;
        private Node next;

        public Node(String item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public TwoWayLinkedList() {
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String get(int index) {
        if (size == 0 || index >= size) {
            return null;
        }

        if (index < size / 2) {
            // 從前往後搜
            Node curr = first;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.item;
        } else {
            // 從後往前搜
            Node curr = last;
            for (int i = size - 1; i > index; i--) {
                curr = curr.pre;
            }
            return curr.item;
        }
    }

    public String getFirst() {
        return first == null ? null : first.item;
    }

    public String getLast() {
        return last == null ? null : last.item;
    }


    public void addFirst(String item) {
        Node curr = first;
        Node newNode = new Node(item, null, null);

        // 如果沒有節點時
        if (size == 0) {
            first = last = newNode;
            size++;
            return;
        }

        // 第一個節點的上一個節點
        first.pre = newNode;

        // 改變第一個節點
        first = newNode;

        // 新的第一個節點的下一個節點
        first.next = curr;

        size++;
    }

    public void addLast(String item) {
        Node curr = last;
        Node newNode = new Node(item, null, null);

        // 如果沒有節點時
        if (size == 0) {
            first = last = newNode;
            size++;
            return;
        }

        // 最後一個節點的下一個節點
        last.next = newNode;

        // 改變最後一個節點
        last = newNode;

        // 新的最後一個節點的上一個節點
        last.pre = curr;

        size++;
    }


    public void insert(int index, String item) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("超出索引值");
        }

        Node newNode = new Node(item, null, null);

        // 如果是頭節點
        if (index == 0) {
            addFirst(item);
            return;
        }

        // 如果是尾節點
        if (index == size - 1) {
            addLast(item);
            return;
        }

        // 非頭尾節點
        Node current;
        if (index < size / 2) {
            // 從頭往後找
            current = first;

            // 找到 index 的 node
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // 從尾往前找
            current = last;

            // 找到 index 的 node
            for (int i = size - 1; i > index; i--) {
                current = current.pre;
            }
        }

        // 找到 index 前一個 node
        Node pre = current.pre;

        // 四條指針轉換
        pre.next = newNode;
        newNode.pre = pre;

        current.pre = newNode;
        newNode.next = current;

        size++;
    }

    public String removeFirst() {
        // 如果沒有節點時
        if (first == null) {
            return null;
        }

        // 如果只有一個節點時
        if (size == 1) {
            String result = first.item;
            first = last = null;
            size--;
            return result;
        }

        String result = first.item;
        // 第一個節點的下一個節點
        first = first.next;
        // 第一個節點的上一個節點
        first.pre = null;

        size--;
        return result;
    }

    public String removeLast() {
        // 如果沒有節點時
        if (last == null) {
            return null;
        }

        // 如果只有一個節點時
        if (size == 1) {
            String result = last.item;
            first = last = null;
            size--;
            return result;
        }

        String result = last.item;
        // 最後一個節點的上一個節點
        last = last.pre;
        // 最後一個節點的下一個節點
        last.next = null;

        size--;
        return result;
    }

    public String remove(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("超出索引值");
        }

        // 如果是頭節點
        if (index == 0) {
            return removeFirst();
        }

        // 如果是尾節點
        if (index == size - 1) {
            return removeLast();
        }

        // 非頭尾節點
        Node current;
        if (index < size / 2) {
            // 從頭往後找
            current = first;

            // 找到 index 的 node
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // 從尾往前找
            current = last;

            // 找到 index 的 node
            for (int i = size - 1; i > index; i--) {
                current = current.pre;
            }
        }

        // 保存 return 資料
        String result = current.item;

        // 找到 index 前一個 node
        Node pre = current.pre;

        // 找到 index 下一個 node
        Node next = current.next;

        // 兩條指針轉換
        pre.next = next;
        next.pre = pre;

        size--;
        return result;
    }

    public int indexOf(String item) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.item, item)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    public int lastIndexOf(String item) {
        Node node = last;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(node.item, item)) {
                return i;
            }
            node = node.pre;
        }
        return -1;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {
        private Node node;

        public MyIterator() {
            node = first;
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
        TwoWayLinkedList list = new TwoWayLinkedList();
        list.addLast("b");
        list.addLast("c");
        list.addFirst("a");

        System.out.println(list.first);

        System.out.println(list.get(1));
        list.insert(0, "start");
        list.insert(3, "end");
        list.insert(3, "middle");
        System.out.println(list.first);

        list.clear();
        list.insert(0, "haha");

        System.out.println(list.indexOf("xxx"));
        System.out.println(list.lastIndexOf("haha"));

        list.remove(0);
        System.out.println(list.first);
    }
}
