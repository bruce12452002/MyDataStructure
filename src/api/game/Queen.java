package api.game;

/**
 * 皇后可以攻擊橫線直線斜線，八皇后問題是放 8 個皇后在 8x8 的棋盤上，彼此都不會互相攻擊
 * <p>
 * 使用一維陣列即可，每行只能放一個，不然就違反了橫線的規則
 * 所以索引 0 放 0；索引 1 放 4；索引 2 放 7，就表示 0,0   1,4   2,7，這樣可以模擬二維陣列而且節省空間，也就是 array[row] = column
 */
public class Queen {
    static int queenSize = 8; // 幾個皇后
    static int[] chess = new int[queenSize]; // 幾x幾的棋盤
    static int count = 0; // 總共多少解

    /**
     *
     * @param currentQueen 放第幾個皇后，從 0 開始
     */
    public void putChess(int currentQueen) {
    }

    private boolean check(int currentQueen) {
        return false;
    }


    private void print() {
    }

    public static void main(String[] args) {
        new Queen().putChess(0);
        System.out.println(count);
    }
}
