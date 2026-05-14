package practice.linear;

/**
 * key 需要排序
 */
public class SortMapWithLinkedList extends MapWithLinkedList {
    public void put(String key, String value) {
        if (head == null) {
            head = new Node(key, value, null);
            size++;
            return;
        }

        // 找插入位置，以頭節點的下一個節點為基準點
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            int compare = key.compareTo(curr.key);

            // 有重覆的 key 就更新 value
            if (compare == 0) {
                curr.value = value;
                return;
            }

            if (compare < 0) {
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        // 插入
        if (prev == null) {
            head = new Node(key, value, head);
        } else {
            prev.next = new Node(key, value, curr);
        }
        size++;
    }

    public static void main(String[] args) {
        SortMapWithLinkedList map = new SortMapWithLinkedList();
        map.put("b", "banana");
        map.put("a", "apple");
        map.put("一", "一而十");
        map.put("十", "十而百");
        System.out.println(map);
    }
}
