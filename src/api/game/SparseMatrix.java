package api.game;


public class SparseMatrix {
    private int[][] chessArray;
    private int size; // 總共有幾個棋子

    public SparseMatrix(int rows, int columns) {
    }

    private enum ChessColor {
        White(1), Black(2);

        private final int color;

        ChessColor(int color) {
            this.color = color;
        }
    }

    /**
     * 插入黑子和白子，不用從 0 開始，方法會自動轉成陣列的格式
     *
     * @param row    橫
     * @param column 直
     * @param chessColor  1為白子； 2為黑子； 0為預設值，表示還沒放子
     */
    public void insert(int row, int column, ChessColor chessColor) {
        if (row - 1 > chessArray.length || column - 1 > chessArray[0].length) {
            throw new IllegalArgumentException("超出棋盤大小");
        }

    }

    private boolean isNonExist(int row, int column) {
        return false;
    }

    public void showArray() {
    }

    public void arrayToSparse() {
    }

    public void sparseToArray() {
    }

    public static void main(String[] args) {
        SparseMatrix sparseMatrix = new SparseMatrix(7, 7);
        sparseMatrix.insert(2, 3, ChessColor.White);
        sparseMatrix.insert(2, 4, ChessColor.Black);
        sparseMatrix.insert(3, 6, ChessColor.White);
        sparseMatrix.insert(4, 3, ChessColor.Black);

        sparseMatrix.showArray();
        sparseMatrix.arrayToSparse();
        sparseMatrix.showArray();
        sparseMatrix.sparseToArray();
        sparseMatrix.showArray();
    }
}
