public class kruskals {

    static final int INF = Integer.MAX_VALUE;

    // class to represent an edge in the graph
    static class Edge {
        int src, dest;
        double weight;

        Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // class to represent a subset for union-find
    static class Subset {
        int parent, rank;
    }

    // function to find the parent of an element (with path compression)
    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }


    void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    // function to perform kruskal's
    void kruskalMST(int V, Edge[] edges) {
        Edge[] result = new Edge[V - 1];
        int e = 0;
        int i = 0;

        // step 1: Sort edges in non-decreasing order of their weight
        for (int a = 0; a < edges.length - 1; a++) {
            for (int b = 0; b < edges.length - a - 1; b++) {
                if (edges[b].weight > edges[b + 1].weight) {
                    Edge temp = edges[b];
                    edges[b] = edges[b + 1];
                    edges[b + 1] = temp;
                }
            }
        }

        // create V subsets with single elements
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        // number of edges in MST will be V-1
        while (e < V - 1 && i < edges.length) {
            // Step 2: Pick the smallest edge
            Edge nextEdge = edges[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // if including this edge doesn't cause a cycle
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        //print
        System.out.println("Edge \t Weight");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + "\t" + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices (A, B, C, D, E, F)
        Edge[] edges = {
            new Edge(0, 1, 3.68), // A-B
            new Edge(0, 3, 2.41), // A-D
            new Edge(0, 4, 7.71), // A-E
            new Edge(1, 2, 6.01), // B-C
            new Edge(2, 3, 5.52), // C-D
            new Edge(2, 5, 8.42), // C-F
            new Edge(3, 4, INF),  // D-E (no connection)
            new Edge(4, 5, 9.97)  // E-F
        };

        kruskals ka = new kruskals();
        ka.kruskalMST(V, edges);
    }
}