package practice.graph;

import practice.linear.ArrayList2;

public class GraphWithArray {
    private int vertex; // 頂點數
    private int edge; // 邊數
    private boolean[][] matrix;

    public GraphWithArray(int vertex) {
        this.vertex = vertex;
        this.matrix = new boolean[vertex][vertex];
    }

    public int getVertexSize() {
        return vertex;
    }

    public int getEdgeSize() {
        return edge;
    }

    public void addEdge(int from, int to) {
        checkVertex(from);
        checkVertex(to);

        if (!matrix[from][to]) {
            matrix[from][to] = true;
            matrix[to][from] = true;
            edge++;
        }
    }

    public void removeEdge(int from, int to) {
        checkVertex(from);
        checkVertex(to);

        if (matrix[from][to]) {
            matrix[from][to] = false;
            matrix[to][from] = false;
            edge--;
        }
    }

    /**
     * 取得某個頂點的所有相鄰節點
     */
    public ArrayList2 getAdjacent(int vertex) {
        checkVertex(vertex);

        ArrayList2 list = new ArrayList2(10);
        for (var i = 0; i < this.vertex; i++) {
            if (matrix[vertex][i]) {
                list.append(String.valueOf(i));
            }
        }
        return list;
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
