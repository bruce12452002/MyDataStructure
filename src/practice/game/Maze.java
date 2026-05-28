package practice.game;

/**
 * 從 1,1 走到 6,6
 */
public class Maze {
    private MazeStatus[][] map = new MazeStatus[8][8]; // null 沒走過； 1 牆； 2 可走； 3 路不通

    public Maze() {
        generalWall();
    }

    private enum MazeStatus {
        WALL(1), ROAD(2), NO_ROAD(3);
        private final int status;

        MazeStatus(int status) {
            this.status = status;
        }
    }

    private void generalWall() {
        for (var i = 0; i < map.length; i++) {
            map[i][0] = MazeStatus.WALL;
            map[i][map.length - 1] = MazeStatus.WALL;
        }

        for (var i = 1; i < map[0].length; i++) {
            map[0][i] = MazeStatus.WALL;
            map[map.length - 1][i] = MazeStatus.WALL;
        }

        map[2][3] = MazeStatus.WALL;
        map[2][4] = MazeStatus.WALL;
        map[2][5] = MazeStatus.WALL;
        map[3][5] = MazeStatus.WALL;
        map[4][5] = MazeStatus.WALL;
        map[4][6] = MazeStatus.WALL;
    }

    public void showMap() {
        for (MazeStatus[] i : map) {
            for (MazeStatus m : i) {
                System.out.print((m == null ? "0" : m.status) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean findWay(int i, int j) {
        if (map[6][6] == MazeStatus.ROAD) { // 6, 6 為終點
            return true;
        }

        if (map[i][j] == null) {
            map[i][j] = MazeStatus.ROAD;
            return strategy1(i, j);
        }
        return false;
    }

    /**
     * 依照上下左右的順序找路
     */
    private boolean strategy1(int i, int j) {
        if (findWay(i - 1, j)) {
            return true;
        } else if (findWay(i + 1, j)) {
            return true;
        } else if (findWay(i, j - 1)) {
            return true;
        } else if (findWay(i, j + 1)) {
            return true;
        } else {
            map[i][j] = MazeStatus.NO_ROAD;
        }
        return false;
    }

    /**
     * 依照下右左上的順序找路
     */
    private boolean strategy2(int i, int j) {
        if (findWay(i + 1, j)) {
            return true;
        } else if (findWay(i, j + 1)) {
            return true;
        } else if (findWay(i, j - 1)) {
            return true;
        } else if (findWay(i - 1, j)) {
            return true;
        } else {
            map[i][j] = MazeStatus.NO_ROAD;
        }
        return false;
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.showMap();
        maze.findWay(1, 1); // 1,1 為起點
        maze.showMap();
    }
}
