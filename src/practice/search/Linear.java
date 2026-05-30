package practice.search;

import practice.linear.ArrayList2;

import java.util.Objects;

/**
 * 線性搜尋
 */
public class Linear {
    /**
     * 從前往後找
     */
    public int indexOf(String[] arr, String targetValue) {
        for (var i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], targetValue)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 從後往前找
     */
    public int lastIndexOf(String[] arr, String targetValue) {
        for (var i = arr.length - 1; i >= 0; i++) {
            if (Objects.equals(arr[i], targetValue)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 從頭到尾找
     */
    public ArrayList2 allIndexOf(String[] arr, String targetValue) {
        ArrayList2 list = new ArrayList2(10);
        for (var i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], targetValue)) {
                list.append(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "a", "c", "a"};
        Linear linear = new Linear();
        System.out.println(linear.indexOf(arr, "a"));
        System.out.println(linear.lastIndexOf(arr, "a"));
        linear.allIndexOf(arr, "a").forEach(s -> System.out.print(s + " "));
    }
}
