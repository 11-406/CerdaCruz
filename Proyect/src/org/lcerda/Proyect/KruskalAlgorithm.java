package org.lcerda.Proyect;

import java.io.*;
import java.util.*;

public class KruskalAlgorithm {
    static int iterationCount = 0;

    public static void main(String[] args) throws IOException {

        File folder = new File("input");
        File[] files = folder.listFiles((dir, name) -> name.startsWith("graph_") && name.endsWith(".txt"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println("Processing archive: " + file.getName());
                BufferedReader br = new BufferedReader(new FileReader(file));

                String[] firstLine = br.readLine().split(" ");
                int nodes = Integer.parseInt(firstLine[0]);
                int edgesCount = Integer.parseInt(firstLine[1]);

                List<Edge> edges = new ArrayList<>();
                for (int i = 0; i < edgesCount; i++) {
                    String[] parts = br.readLine().split(" ");
                    int u = Integer.parseInt(parts[0]);
                    int v = Integer.parseInt(parts[1]);
                    int weight = Integer.parseInt(parts[2]);
                    edges.add(new Edge(u, v, weight));
                }

                // Medir tiempo
                long startTime = System.nanoTime();
                List<Edge> mst = kruskal(nodes, edges);
                long endTime = System.nanoTime();

                double durationMs = (endTime - startTime) / 1_000_000.0;

                System.out.println("TIME OF EJECUTION: " + durationMs + " ms");
                System.out.println("NUMBERS OF ITERATIONS: " + iterationCount);
                System.out.println("SIZE OF MST: " + mst.size() + " edges");

                int totalWeight = 0;
                for (Edge e : mst) totalWeight += e.weight;
                System.out.println("TOTAL WEIGHT MST: " + totalWeight);
                System.out.println("=====================================");
            }
        }else {
            System.out.println("Doesnt exist files inside the folder");
        }

    }

    public static List<Edge> kruskal(int nodes, List<Edge> edges) {
        Collections.sort(edges); // Paso 1: ordenar aristas por peso
        UnionFind uf = new UnionFind(nodes);
        List<Edge> mst = new ArrayList<>(); // Minimum Spanning Tree

        for (Edge edge : edges) {
            iterationCount++;
            if (uf.union(edge.src, edge.dest)) {
                mst.add(edge);
                if (mst.size() == nodes - 1)
                    break;
            }
        }

        return mst;
    }
}

