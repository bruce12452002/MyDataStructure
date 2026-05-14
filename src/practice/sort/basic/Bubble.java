package practice.sort.basic;

import java.util.Arrays;

public class Bubble {
    /**
     * 0123
     * 012
     * 01
     * 0
     */
//    public int[] sort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                System.out.print(j);
//            }
//            System.out.println();
//        }
//        return null;
//    }
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
//            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (compare(arr[j], arr[j + 1])) {
                    exchange(arr, j, j + 1);
//                    swapped = true;
                }
            }
//            if (!swapped) {
//                break; // 沒有交換，提前結束
//            }
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
        int[] arr = {5, 4, 3, 2, 1};
        int[] result = new Bubble().sort(arr);
        System.out.println(Arrays.toString(result));
    }
}
