package org.lcerda.Proyect;

    public class Edge implements Comparable<Edge> {
    int src, dest, weight; //src = nodo de origen ; dest = destination

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
