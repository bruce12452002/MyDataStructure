package api.game;

/**
 * 從 1,1 走到 6,6
 */
public class Maze {
    private int[][] map = new int[8][8]; // 0 沒走過； 1 牆； 2 可走； 3 路不通

    public Maze() {
        generalWall();
    }

    private void generalWall() {
    }

    public void showMap() {
    }

    public boolean findWay(int i, int j) {
        return false;
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.showMap();
        maze.findWay(1, 1); // 1,1 為起點
        maze.showMap();
    }
}
