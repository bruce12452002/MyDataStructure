package practice.circle.question;

/**
 * 羅馬人佔領喬塔帕特後，39 個猶太人與歷史學家 Josephus 及朋友躲到一個洞中，39 個
 * 猶太人決定寧願死也不要被敵人抓到，於是決定了一個自殺方式，41 個人排成一個圓圈，由
 * 1、2、3 連續報數，每逢報第 3 人就必須自殺，直到所有人都自殺身亡為止。然而 Josephus 和
 * 他的朋友並不想遵從，將朋友與自己安排在第 16 個與第 31 個位置，逃過了這場死亡遊戲。
 */
public class JosephusProblem {

    private static class Node {
        private final int item;
        private Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static Node getCircle(int people) {
        Node last = new Node(people--, null);
        Node pre = last;

        for (int i = people; i > 0; i--) {
            pre = new Node(i, pre);
        }
        last.next = pre;
        return pre;
    }

    public static void main(String[] args) {
        Node first = getCircle(41);
        System.out.println(first);

        Node pre = null;
        int count = 0;
        while (first != first.next) {
            count++;

            if (count % 3 == 0) {
                pre.next = first.next; // 2->4, 5->7 依此類推
                System.out.print(first.item + ", "); // ... 16
            } else {
                pre = first; // 在 first.next 前先存起來，變成上一個節點
            }
            first = first.next;
        }
        System.out.println(first.item); // 31
    }
}
