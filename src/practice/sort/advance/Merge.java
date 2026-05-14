package practice.sort.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    /**
     * (v) 表示會印 xxx，左右都完成才會印
     *
     *                 [0,1,2,3,4] (O)(v)
     *                /             \
     *         [0,1] (A)(v)     [2,3,4] (B)(v)
     *         /     \           /       \
     *     [0](A)  [1](B)   [2](A)   [3,4](B)(v)
     *                                    /   \
     *                                [3](A) [4](B)
     */
    public List<Integer> sortWithList(List<Integer> list, String flag) {
        System.out.println(flag + "=> " + list);
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }
        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i));
        }
        sortWithList(left, "A");
        sortWithList(right, "B");
        System.out.println("xxx");
        return null;
    }

    public List<Integer> sortWithList(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }
        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i));
        }
        left = sortWithList(left);
        right = sortWithList(right);
        return sortWithList(left, right);
    }

    private List<Integer> sortWithList(List<Integer> left, List<Integer> right) {
        List<Integer> temp = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0) <= right.get(0)) {
                temp.add(left.get(0));
                left.remove(0);
            } else {
                temp.add(right.get(0));
                right.remove(0);
            }
        }

        if (!left.isEmpty()) {
            for (int i = 0; i < left.size(); i++) {
                temp.add(left.get(i));
            }
        }
        if (!right.isEmpty()) {
            for (int i = 0; i < right.size(); i++) {
                temp.add(right.get(i));
            }
        }

        return temp;
    }

    // ================================================================================================================

    public void sortWithArray(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        sortWithArray(arr, 0, arr.length - 1);
    }

    private void sortWithArray(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        sortWithArray(arr, left, mid);
        sortWithArray(arr, mid + 1, right);

        sortWithArray(arr, left, mid, right);
    }

    private void sortWithArray(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 假設 left = 2, right = 4，索引是包含左右邊界的，只需要 3 個位置就夠了

        int i = left;      // 左半邊起點
        int j = mid + 1;   // 右半邊起點
        int k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        // 左邊剩餘
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 右邊剩餘
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 複製回原陣列
//        for (int t = 0; t < temp.length; t++) {
//            arr[left + t] = temp[t];
//        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> result = new Merge().sortWithList(list, "O");
//        List<Integer> result = new Merge().sortWithList(list);
        System.out.println(result);

//        int[] arr = {5, 4, 3, 2, 1};
//        new Merge().sortWithArray(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
