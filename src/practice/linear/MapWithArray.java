package practice.linear;


import java.util.Iterator;
import java.util.Objects;

public class MapWithArray implements Iterable<String> {
    protected Node[] table;
    protected int size;

    protected static class Node {
        protected final String key;
        protected String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public MapWithArray() {
        table = new Node[10];
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(String key, String value) {
        // 有重覆的 key 就更新 value
        for (int i = 0; i < size; i++) {
            Node node = table[i];
            if (Objects.equals(key, node.key)) {
                node.value = value;
                return;
            }
        }

        if (size == table.length) {
            resize(table.length * 2);
        }

        table[size++] = new Node(key, value);
    }

    public String remove(String key) {
        for (int i = 0; i < size; i++) {
            Node node = table[i];
            if (Objects.equals(key, node.key)) {
                String result = node.value;
                for (int j = i; j < size - 1; j++) {
                    table[j] = table[j + 1]; // 左移
                }
                table[--size] = null;

                if (size > 0 && size == table.length / 4) {
                    resize(table.length / 2);
                }

                return result;
            }
        }
        return null;
    }

    public String get(String key) {
        for (int i = 0; i < size; i++) {
            Node node = table[i];
            if (Objects.equals(key, node.key)) {
                return node.value;
            }
        }
        return null;
    }

    protected void resize(int capacity) {
        Node[] newTable = new Node[capacity];
        for (int i = 0; i < size; i++) {
            newTable[i] = table[i];
        }
        table = newTable;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<String> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public String next() {
            return table[cursor++].value;
        }
    }

    public static void main(String[] args) {
        MapWithArray map = new MapWithArray();
        map.put("a", "apple");
        map.put("b", "banana");
        map.put("p", "pineapple");
        System.out.println(map.get("b"));
        System.out.println(map.remove("a"));

        System.out.println("=============================");
        for (String str : map) {
            System.out.println(str);
        }
    }
}
