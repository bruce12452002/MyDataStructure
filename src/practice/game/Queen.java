package practice.game;

/**
 * 皇后可以攻擊橫線直線斜線，八皇后問題是放 8 個皇后在 8x8 的棋盤上，彼此都不會互相攻擊
 * <p>
 * 使用一維陣列即可，每行只能放一個，不然就違反了橫線的規則
 * 所以索引 0 放 0；索引 1 放 4；索引 2 放 7，就表示 0,0   1,4   2,7，這樣可以模擬二維陣列而且節省空間，也就是 array[row] = column
 */
public class Queen {
    static int queenSize = 4; // 幾個皇后
    static int[] chess = new int[queenSize]; // 幾x幾的棋盤
    static int count = 0; // 總共多少解

    /**
     *
     * @param currentQueen 放第幾個皇后，從 0 開始
     */
    public void putChess(int currentQueen) {
        if (currentQueen == queenSize) {
            print();
            ++count;
            return;
        }

        for (int i = 0; i < queenSize; i++) {
            chess[currentQueen] = i;
            if (check(currentQueen)) {
                putChess(currentQueen + 1); // 放下一個皇后
            }
        }
    }

    private boolean check(int currentQueen) {
        for (int j = 0; j < currentQueen; j++) {
            // 直線不可放 (判斷 column)
            if (chess[j] == chess[currentQueen]) {
                return false;
            }

            // 斜線不可放的公式
            /**
             *     索 0 1 2 3 4 5 6 7
             *     值   4 3 2
             *
             *     以下是棋盤
             *        0 1 2 3 4 5 6 7
             *     0
             *     1          v
             *     2        v
             *     3      v
             *     4
             *     5
             *     6
             *     7
             *
             *     索引 3-1 = 2； 元素值 2 - 4 = -2，所以絕對值都是 2，是斜線
             *     索引 3-2 = 1； 元素值 2 - 3 = -1，所以絕對值都是 1，是斜線
             *
             *
             *     又例如
             *     索 0 1 2 3 4 5 6 7
             *     值   0 1 2
             *     索引 3-1 = 2； 元素值 2 - 0 = 2，所以絕對值都是 2，是斜線
             *     索引 3-2 = 1； 元素值 2 - 1 = 1，所以絕對值都是 1，是斜線
             *
             *     以棋盤來說，上下相差幾格，左右就相差幾格，這樣就是斜線
             *
             */
//            if (Math.abs(currentQueen - j) == Math.abs(chess[currentQueen] - chess[j])) {
//                return false;
//            }

            if (!leftUp(currentQueen)) { // 左上斜線
                return false;
            }

            if (!rightUp(currentQueen)) { // 右上斜線
                return false;
            }
        }
        return true;
    }

    private boolean leftUp(int currentQueen) {
        int row = currentQueen - 1; // 往上要減
        int col = chess[currentQueen] - 1; // 往左要減
        while (row >= 0 && col >= 0) {
            if (chess[row] == col) {
                return false;
            }
            row--;
            col--;
        }
        return true;
    }

    private boolean rightUp(int currentQueen) {
        int row = currentQueen - 1; // 往上要減
        int col = chess[currentQueen] + 1; // 往右要加
        while (row >= 0 && col < queenSize) {
            if (chess[row] == col) {
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < queenSize; i++) {
            System.out.print(chess[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Queen().putChess(0);
        System.out.println(count);
    }
}
