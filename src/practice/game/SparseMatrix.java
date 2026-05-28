package practice.game;


public class SparseMatrix {
    private int[][] chessArray;
    private int size; // 總共有幾個棋子

    public SparseMatrix(int rows, int columns) {
        chessArray = new int[rows][columns];
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

        if (isNonExist(row - 1, column - 1)) { // 沒下子才能新增
            chessArray[row - 1][column - 1] = chessColor.color;
            size++;
        }
    }

    private boolean isNonExist(int row, int column) {
        return chessArray[row][column] == 0;
    }

    public void showArray() {
//        for (var i = 0; i < chessArray.length; i++) {
//            for (var j = 0; j < chessArray[0].length; j++) {
//                System.out.print(chessArray[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int[] i : chessArray) {
            for (int color : i) {
                System.out.print(color + " ");
            }
            System.out.println();
        }
    }

    public void arrayToSparse() {
        int[][] newChessArray = new int[size + 1][3];
        newChessArray[0][0] = chessArray.length;
        newChessArray[0][1] = chessArray[0].length;
        newChessArray[0][2] = size;

        int count = 0;
        for (var i = 0; i < chessArray.length; i++) {
            for (var j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    newChessArray[count][0] = i;
                    newChessArray[count][1] = j;
                    newChessArray[count][2] = chessArray[i][j];
                }
            }
        }
        chessArray = newChessArray;
    }

    public void sparseToArray() {
        int[][] newChessArray = new int[chessArray[0][0]][chessArray[0][1]];

        for (var i = 1; i < chessArray.length; i++) {
            newChessArray[chessArray[i][0]][chessArray[i][1]] = chessArray[i][2];
        }
        chessArray = newChessArray;
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
