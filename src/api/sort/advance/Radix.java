package api.sort.advance;

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
        sort(arr, true);
    }

    public void sort(int[] arr, boolean asc) {
        final int TEN = 10;
        int[][] bucket = new int[TEN][arr.length];
        int[] count = new int[TEN];
        int maxLength = getMaxLength(arr);

    }

    private int getMaxLength(int[] arr) {
        return -1;
    }

    public static void main(String[] args) {
        new Radix().sort(new int[]{40, 89, 120, 739, 330});
        new Radix().sort(new int[]{40, 89, 120, 739, 330}, false);
    }
}
