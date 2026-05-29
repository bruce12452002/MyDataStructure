package practice.sort.advance;

import java.util.Arrays;

/**
 * 規則： 假設有以下 5 個數
 * 40, 89, 120, 739, 330
 * <p>
 * 個位數
 * 0桶	  9桶
 * 40	  89
 * 120   739
 * 330
 * <p>
 * <p>
 * 十位數
 * 2桶	  3桶   4桶	  8桶
 * 120   330   40    89
 * 739
 * <p>
 * <p>
 * 百位數
 * 0桶	  1桶   3桶	  7桶
 * 40    120   330   739
 * 89
 * <p>
 * 只做到所有要排的數裡最大的「位」
 */

/**
 * 基數排序不支援負數
 * <p>
 * 如果要支援負數，還得將要排的資料分成負數和正數兩類
 * 然後將負數那組全部都乘 -1，使其變成正數來排，排完之後再乘 -1 還原
 * 但這時會變成倒序，所以還要反轉，最後再將正數那組接在後面
 * 由於負數會變成倒序，所以不可以將 bucket 增加 -1 ~ -9 來解決這問題
 */
public class Radix {
    public void sort(int[] arr) {
        if (arr.length == 0) return;
        sort(arr, true);
    }

    public void sort(int[] arr, boolean asc) {
        final int TEN = 10;
        int[][] bucket = new int[TEN][arr.length];
        int[] count = new int[TEN];
        int maxLength = getMaxLength(arr);

        for (int i = 0, y = 1; i < maxLength; i++, y *= TEN) {
            for (var j = 0; j < arr.length; j++) {
                /**
                 * 取得個十百位的公式：
                 * 外層迴圈第一次進來是 /1 % 10
                 * 外層迴圈第二次進來是 /10 % 10
                 * 外層迴圈第三次進來是 /100 % 10
                 */
                int n = arr[j] / y % TEN; // 取得要放在哪個桶

                /**
                 * 假設有有 5 個數字要排，分別是 232 30 92 20 400
                 *      0   1   2   3   4
                 *  0  30  20  400
                 *  1
                 *  2  232 92
                 *
                 *  第一次 bucket[n][?] 是 bucket[2][?]
                 *  然後 ? 是 count[0] --> count[1] --> count[2] 累加
                 *  所以是 bucket[2][0]
                 *  第二次就是 bucket[0][0]
                 *  第三次就是 bucket[2][1]
                 *  第四次就是 bucket[0][1]
                 *  第五次就是 bucket[0][2]
                 */
                bucket[n][count[n]++] = arr[j]; // 將 0-9 放入陣列的桶並計數
            }

            // 改變原陣列
            int index = 0;
            if (asc) {
                for (var k = 0; k < TEN; k++) { // 升序或降序只差在這
                    if (count[k] > 0) {
                        for (var x = 0; x < count[k]; x++) {
                            arr[index++] = bucket[k][x];
                        }
                    }
                    count[k] = 0;
                }
            } else {
                for (var k = TEN - 1; k >= 0; k--) { // 升序或降序只差在這
                    if (count[k] > 0) {
                        for (var x = 0; x < count[k]; x++) {
                            arr[index++] = bucket[k][x];
                        }
                    }
                    count[k] = 0;
                }
            }
            System.out.println("第" + (i + 1) + "輪：" + Arrays.toString(arr));
        }
    }

    private int getMaxLength(int[] arr) {
        int max = arr[0];
        for (var i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return String.valueOf(max).length();
    }

    public static void main(String[] args) {
        int[] data = {40, 89, 120, 739, 330};
        new Radix().sort(data);
        new Radix().sort(data, false);
    }
}
