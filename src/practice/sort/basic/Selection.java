package practice.sort.basic;

import java.util.Arrays;

public class Selection {
    /**
     * 0,1  0,2  0,3  0,4
     * 1,2  1,3  1,4
     * 2,3  2,4
     * 3,4
     */
//    public int[] sort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                System.out.print(i + "," + j + "  ");
//            }
//            System.out.println();
//        }
//        return arr;
//    }

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (compare(arr[i], arr[j])) {
                    exchange(arr, i, j);
                }
            }
        }
        return arr;
    }

//    public int[] sort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minIndex = i; // 紀錄最小索引
//
//            for (int j = i + 1; j < arr.length; j++) {
//                if (compare(arr[minIndex], arr[j])) {
//                    minIndex = j;
//                }
//            }
//            exchange(arr, i, minIndex); // 內層迴圈只交換一次
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
        int[] result = new Selection().sort(arr);
        System.out.println(Arrays.toString(result));
    }
}
