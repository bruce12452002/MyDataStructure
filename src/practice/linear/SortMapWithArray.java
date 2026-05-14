package practice.linear;


/**
 * key 需要排序
 */
public class SortMapWithArray extends MapWithArray {
    public void put(String key, String value) {
        // 找 key 或 找插入位置
        int index = 0;
        while (index < size) {
            Node node = table[index];
            int compare = key.compareTo(node.key);
            // 有重覆的 key 就更新 value
            if (compare == 0) {
                node.value = value;
                return;
            }

            // 找到插入位置
            if (compare < 0) {
                break;
            }
            index++;
        }

        if (size == table.length) {
            resize(table.length * 2);
        }

        for (int i = size; i > index; i--) {
            table[i] = table[i - 1]; // 右移
        }

        // 插入
        table[index] = new Node(key, value);
        size++;
    }

    public static void main(String[] args) {
        SortMapWithArray map = new SortMapWithArray();
        map.put("b", "banana");
        map.put("a", "apple");
        map.put("一", "一而十");
        map.put("十", "十而百");
        System.out.println(map);
    }
}
