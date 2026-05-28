package api.graph;

import practice.linear.ArrayList2;

public class GraphWithArray {
    private int vertex; // 頂點數
    private int edge; // 邊數
    private boolean[][] matrix;

    public GraphWithArray(int vertex) {
    }

    public int getVertexSize() {
        return -1;
    }

    public int getEdgeSize() {
        return -1;
    }

    public void addEdge(int from, int to) {
    }

    public void removeEdge(int from, int to) {
    }

    /**
     * 取得某個頂點的所有相鄰節點
     */
    public ArrayList2 getAdjacent(int vertex) {
        return null;
    }

    private void checkVertex(int vertex) {
        if (vertex < 0 || vertex >= this.vertex) {
            throw new IllegalArgumentException("頂點超過範圍");
        }
    }

    public static void main(String[] args) {
        GraphWithArray graph = new GraphWithArray(5);
        graph.addEdge(1, 3);
        graph.addEdge(4, 2);
        graph.addEdge(1, 2);

        graph.removeEdge(4, 2);

        ArrayList2 list = graph.getAdjacent(1);
        for (var i = 0; i < list.length(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }
}
