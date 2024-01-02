package graph;

public class Edge {
    int src;
    int dest;
    int weight;

    Edge(int _src, int _dest) {
        src = _src;
        dest = _dest;
    }

    Edge(int _src, int _dest, int _weight) {
        src = _src;
        dest = _dest;
        weight = _weight;
    }

    @Override
    public String toString() {
        return "(" + src + "," + dest + "," + weight + ")";
    }
}
