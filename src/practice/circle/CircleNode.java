package practice.circle;

public class CircleNode {
    private static class Node {
        private final String item;
        private Node next;

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * 取得中間節點，不可有循環
     */
    public static Node getMiddle(Node first) {
        Node slow = first;
        Node fast = first;

        while (slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 是否循環
     */
    public static boolean isCircle(Node first) {
        Node slow = first;
        Node fast = first;

        while (slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 取得循環的入口
     */
    public static Node getEntrance(Node first) {
        Node slow = first;
        Node fast = first;
        Node temp = null;

        while (slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                temp = first;
                continue;
            }

            if (temp != null) {
                temp = temp.next;

                if (temp == slow) {
                    break;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Node n8 = new Node("h", null);
        Node n7 = new Node("g", n8);
        Node n6 = new Node("f", n7);
        Node n5 = new Node("e", n6);
        Node n4 = new Node("d", n5);
        Node n3 = new Node("c", n4);
        Node n2 = new Node("b", n3);
        Node n1 = new Node("a", n2);

        n8.next = n4; // 循環

        boolean isCircle = isCircle(n1);
        System.out.println(isCircle);
        System.out.println(isCircle ? getEntrance(n1).item : getMiddle(n1).item);
    }
}
