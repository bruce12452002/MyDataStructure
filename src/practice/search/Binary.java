package practice.search;

import practice.linear.ArrayList2;

/**
 * 二分搜尋
 * <p>
 * 一次少一半去找，但必需是已排好序
 */
public class Binary {
    /**
     * 從中間開始折半搜尋，找到一個就返回
     *
     * @param arr         待找的陣列
     * @param left        左邊的索引
     * @param right       右邊的索引
     * @param targetValue 目標字串
     * @return 第一次找到的索引
     */
    public int indexOf(String[] arr, int left, int right, String targetValue) {
        if (left > right) return -1;
        int middle = (left + right) / 2;

        if (targetValue.compareTo(arr[middle]) > 0) {
            return indexOf(arr, middle + 1, right, targetValue);
        } else if (targetValue.compareTo(arr[middle]) < 0) {
            return indexOf(arr, left, middle - 1, targetValue);
        } else {
            // 找到了
            return middle;
        }
    }

    /**
     * 從中間開始折半搜尋，如果有重覆的資料，相鄰的都會找
     *
     * @param arr         待找的陣列
     * @param left        左邊的索引
     * @param right       右邊的索引
     * @param targetValue 目標字串
     * @return 全部索引
     */
    public ArrayList2 allIndexOf(String[] arr, int left, int right, String targetValue) {
        ArrayList2 list = new ArrayList2(10);
        if (left > right) return list;

        int middle = (left + right) / 2;

        if (targetValue.compareTo(arr[middle]) > 0) {
            return allIndexOf(arr, middle + 1, right, targetValue);
        } else if (targetValue.compareTo(arr[middle]) < 0) {
            return allIndexOf(arr, left, middle - 1, targetValue);
        } else {
            // 找到了

            // 往左找
            for (var i = middle - 1; i >= 0; i--) {
                if (targetValue.compareTo(arr[i]) != 0) {
                    break;
                }
                list.append(String.valueOf(i));
            }

            list.append(String.valueOf(middle)); // 中間這行仍能需要


            // 往右找
            for (var i = middle + 1; i < arr.length; i++) {
                if (targetValue.compareTo(arr[i]) != 0) {
                    break;
                }
                list.append(String.valueOf(i));
            }

            return list;
        }
    }

    public static void main(String[] args) {
        Binary binary = new Binary();
        String[] arr = {"a", "f", "q", "t", "z"};
//        System.out.println(binary.indexOf(arr, 0, arr.length - 1, "t"));

//        arr = new String[]{"a", "f", "q", "t", "t", "t", "t", "z"};
        arr = new String[]{"a", "f", "q", "r", "s", "s", "s", "t", "t", "t", "t", "z"};
        binary.allIndexOf(arr, 0, arr.length - 1, "t").forEach(s -> System.out.print(s + " "));
    }
}
