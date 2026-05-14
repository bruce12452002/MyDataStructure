package practice.sort.advance;

import java.util.Arrays;

/*
右指針先開始並以陣列第一個為參考值為例，右指針往左找 < 索引 0 的值
左指針往右找 > 索引 0 的值
左右指針的值交換
左指針 >= 右指針就結束迴圈
右指針和參考值交換
交換完後再切割成更小的陣列，然後一直做以上的事，直到陣列無法再分割
 */
public class Quick {
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        int group = partition(arr, startIndex, endIndex);
        sort(arr, startIndex, group - 1);
        sort(arr, group + 1, endIndex);
    }

    private int partition(int[] arr, int startIndex, int endIndex) {
        int key = arr[startIndex];
        int left = startIndex;
        int right = endIndex + 1;

        for (; ; ) {
            while (compare(arr[--right], key)) {
                if (right == startIndex) {
                    break;
                }
            }
            while (compare(key, arr[++left])) {
                if (left == endIndex) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exchange(arr, left, right);
            }
        }

        exchange(arr, startIndex, right);
        return right;
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
        int[] arr = {3, 5, 6, 1, 7, 2, 4};
        new Quick().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
