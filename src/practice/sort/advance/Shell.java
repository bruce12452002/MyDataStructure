package practice.sort.advance;

import java.util.Arrays;

public class Shell {
    private void getGroup(int[] arr) {
        int group = arr.length / 2;
        while (group > 0) {
            System.out.println(group);
            group /= 2;
        }
    }

    public int[] sort(int[] arr) {
        int group = arr.length / 2;
        while (group > 0) {
            for (int i = group; i < arr.length; i++) { // 第一圈 5-9，共 5 次； 第二圈 2-9，共 8 次； 第三圈 1-9，共 9 次
                if (compare(arr[i - group], arr[i])) { // 05 16 27 38 49； 02 13 24 35 46 57 68 79； 01 12 23 34 45 56 67 78 89
                    exchange(arr, i - group, i);
                }
            }
            group /= 2;
        }
        return arr;
    }

    private boolean compare(int a, int b) {
        return a > b;
    }

    private void exchange(int[] arr, int index, int index2) {
        int temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6};
        int[] result = new Shell().sort(arr);
        System.out.println(Arrays.toString(result));
    }

}
