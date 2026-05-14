package api.linear;


public class MapWithArray {
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
    }

    public int length() {
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public void put(String key, String value) {
    }

    public String remove(String key) {
        return null;
    }

    public String get(String key) {
        return null;
    }

    protected void resize(int capacity) {
    }

    public static void main(String[] args) {
    }
}
