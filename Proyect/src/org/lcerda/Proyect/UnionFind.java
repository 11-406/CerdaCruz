package org.lcerda.Proyect;

public class UnionFind {
    private int[] parent,rank;
        //Disjoint Set Union (DSU)
        //parent hacer ejemplo en powertPoint
        //rank se refiere al nivel de los hijios, cunatos gradas tiene , cunta hereica

    public UnionFind(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }

    public int find(int node) {
        if (parent[node] != node){
            parent[node] = find(parent[node]); // Path compression, hace una recursividad
            //para que al final todos apunrten a un solo lider
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int rootU = find(u); //lider
        int rootV = find(v); //lider
        if (rootU == rootV) return false; //si los lideres son iguales ya no se pueden unir

        // Union by rank
        if (rank[rootU] < rank[rootV])
            parent[rootU] = rootV;  // el rango menor se une al rango mayor
        else if (rank[rootU] > rank[rootV])
            parent[rootV] = rootU; //
        else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        return true;
    }
}
