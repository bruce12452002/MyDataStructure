package api.search;

import api.linear.ArrayList2;

/**
 * 線性搜尋
 */
public class Linear {
    /**
     * 從前往後找
     */
    public int indexOf(String[] arr, String targetValue) {
        return -1;
    }

    /**
     * 從後往前找
     */
    public int lastIndexOf(String[] arr, String targetValue) {
        return -1;
    }

    /**
     * 從頭到尾找
     */
    public ArrayList2 allIndexOf(String[] arr, String targetValue) {
        return null;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "a", "c", "a"};
        Linear linear = new Linear();
        System.out.println(linear.indexOf(arr, "a"));
        System.out.println(linear.lastIndexOf(arr, "a"));
        linear.allIndexOf(arr, "a");
    }
}
