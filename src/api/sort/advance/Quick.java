package api.sort.advance;

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

    }

    private void sort(int[] arr, int startIndex, int endIndex) {

    }

    private int partition(int[] arr, int startIndex, int endIndex) {
        return -1;
    }

    private boolean compare(int a, int b) {
        return false;
    }

    private void exchange(int[] arr, int index, int index2) {
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 1, 7, 2, 4};
    }

}
