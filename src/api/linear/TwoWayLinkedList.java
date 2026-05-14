package api.linear;

public class TwoWayLinkedList {
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
    }

    public int length() {
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public String get(int index) {
        return null;
    }

    public String getFirst() {
        return null;
    }

    public String getLast() {
        return null;
    }


    public void addFirst(String item) {

    }

    public void addLast(String item) {

    }


    public void insert(int index, String item) {
    }

    public String removeFirst() {
        return null;
    }

    public String removeLast() {
        return null;
    }

    public String remove(int index) {
        return null;
    }

    public int indexOf(String item) {
        return -1;
    }

    public int lastIndexOf(String item) {
        return -1;
    }

    public static void main(String[] args) {
    }
}
