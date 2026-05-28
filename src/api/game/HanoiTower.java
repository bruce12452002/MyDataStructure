package api.game;

/**
 * 分成兩大步：
 * 只有一個盤子，就是 A -> C
 * 大於一個盤子又分成三小步  A -> B   A -> C   B -> C
 * 不管幾個盤子都分成最後一個盤子和全部盤子少最後一個盤子這兩堆
 * A -> C 是最後一個盤子移動到 C 柱，因為只有一個盤子，所以不用遞迴
 *
 * <p>
 * 起點   輔助   終點
 * A    B     C
 * a          b
 * b          c
 *
 */
public class HanoiTower {
    /**
     * 把 num 個盤子，從 a 利用 b 移到 c
     *
     * @param num 盤子數
     *            注意 abc 都不是固定的柱，是如下的意思
     * @param a   起點
     * @param b   輔助
     * @param c   終點
     */
    public static void hanoi(int num, String a, String b, String c) {
    }


    public static void main(String[] args) {
    }
}
