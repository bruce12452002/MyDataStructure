package practice.graph;

import practice.linear.QueueWithLinkedList;

public class GraphWithLinkedList {
    private int vertex; // 頂點數
    private int edge;   // 邊數
    private QueueWithLinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public GraphWithLinkedList(int vertex) {
        this.vertex = vertex;
        this.adj = new QueueWithLinkedList[vertex];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new QueueWithLinkedList<>();
        }
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

        if (!contains(from, to)) {
            adj[from].enqueue(to);
            adj[to].enqueue(from);
            edge++;
        }
    }

    /**
     * 取得某個頂點的所有相鄰節點
     */
    public QueueWithLinkedList<Integer> getAdjacent(int vertex) {
        checkVertex(vertex);
        return adj[vertex];
    }

    private boolean contains(int from, int to) {
        for (Integer value : adj[from]) {
            if (value == to) {
                return true;
            }
        }
        return false;
    }

    private void checkVertex(int vertex) {
        if (vertex < 0 || vertex >= this.vertex) {
            throw new IllegalArgumentException("頂點超過範圍");
        }
    }


    public static void main(String[] args) {
        GraphWithLinkedList graph = new GraphWithLinkedList(5);
        graph.addEdge(1, 3);
        graph.addEdge(4, 2);
        graph.addEdge(1, 2);
        graph.addEdge(4, 1);

        QueueWithLinkedList<Integer> queue = graph.getAdjacent(1);
        queue.forEach(System.out::println); // 3 2 4，如果不用 GraphWithLinkedList，改用 StackWithLinkedList，結果為 4 2 3
    }
}
