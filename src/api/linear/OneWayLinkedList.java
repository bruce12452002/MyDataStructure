package api.linear;


public class OneWayLinkedList {
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

    public OneWayLinkedList() {
    }

    public void clear() {
    }

    public int length() {
        return -1;
    }

    public String get(int index) {
        return null;
    }

    /**
     * 頭插
     */
    public void append(String item) {
    }

    public void insert(int index, String item) {
    }

    public String remove(int index) {
        return null;
    }

    public int indexOf(String item) {
        return -1;
    }

    /**
     * 單鏈表反轉，模擬雙鏈表的 pre 指針
     */
    public void reverseNode() {
    }

    private Node reverseNode(Node current) {
        return null;
    }

    public static void main(String[] args) {
    }
}
