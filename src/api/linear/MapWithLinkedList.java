package api.linear;

public class MapWithLinkedList {
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
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    /**
     * 頭插
     */
    public void put(String key, String value) {
    }

    public String remove(String key) {
        return null;
    }

    public String get(String key) {
        return null;
    }

    public static void main(String[] args) {
    }
}
