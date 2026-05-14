package api.linear;

/**
 * 單向串列用尾取比較麻煩，因為要改變尾節點時，要取得尾結點的上一個節點，只能從頭節點遍歷
 */
public class StackWithLinkedList {
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
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public void push(String item) {
    }

    public String pop() {
        return null;
    }

    public String peek() {
        return null;
    }

    public static void main(String[] args) {
    }
}
