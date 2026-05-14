package practice.sort.basic;

import java.util.Arrays;

public class Insertion {
    /**
     * 1
     * 21
     * 321
     * 4321
     */
//    public int[] sort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i; j > 0; j--) {
//                System.out.print(j);
//            }
//            System.out.println();
//        }
//        return arr;
//    }
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (compare(arr[j - 1], arr[j])) {
                    exchange(arr, j - 1, j);
                }
            }
        }
        return arr;
    }

//    public int[] sort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int temp = arr[i]; // 待插入的值
//            int j = i;
//
//            for (; j > 0; j--) {
//                if (compare(arr[j - 1], temp)) {
//                    arr[j] = arr[j - 1]; // 往右移動
//                } else {
//                    break;
//                }
//            }
//
//            arr[j] = temp; // 插入
//        }
//        return arr;
//    }

    private boolean compare(int a, int b) {
        return a > b;
    }

    private void exchange(int[] arr, int index, int index2) {
        int temp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int[] result = new Insertion().sort(arr);
        System.out.println(Arrays.toString(result));
    }

}
