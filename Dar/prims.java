public class prims {

    static final double INF = Double.MAX_VALUE; // Updated to handle double values

    int minKey(double[] key, boolean[] included, int V) {
        double min = INF;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!included[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // function to perform Prim's Algorithm
    void primMST(double[][] graph, int V) {
        int[] parent = new int[V];
        double[] key = new double[V];
        boolean[] included = new boolean[V];

        // initialize all keys as infinite and included[] as false
        for (int i = 0; i < V; i++) {
            key[i] = INF;
            included[i] = false;
        }

        // start with the first vertex (arbitrarily choosing vertex 0)
        key[0] = 0;
        parent[0] = -1;

        // the MST will have V vertices
        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, included, V);

            included[u] = true;

            // update key value and parent index of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                // update the key only if graph[u][v] is non-zero, v is not included in MST,
                // and the weight of u-v is smaller than the current key of v
                if (graph[u][v] != 0 && graph[u][v] != INF && !included[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Edge \t Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices (A, B, C, D, E, F)
        double[][] graph = {
            {0, 3.68, INF, 2.41, 7.71, INF}, // A
            {3.68, 0, 6.01, INF, INF, INF}, // B
            {INF, 6.01, 0, 5.52, INF, 8.42}, // C
            {2.41, INF, 5.52, 0, INF, INF}, // D
            {7.71, INF, INF, INF, 0, 9.97}, // E
            {INF, INF, 8.42, INF, 9.97, 0}  // F
        };

        prims pa = new prims();
        pa.primMST(graph, V);
    }
}
