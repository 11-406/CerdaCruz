package org.lcerda.Proyect;

import java.io.*;
import java.util.*;

public class GraphGenerator {
    public static void main(String[] args) throws IOException {
        Random rand = new Random();

        for (int n = 100; n <= 10000; n += 200) {
            int edges = n + rand.nextInt(n); // Asegurar conectividad + algo más
            String filename = "input/graph_" + n + ".txt";
            PrintWriter writer = new PrintWriter(new FileWriter(filename));

            writer.println(n + " " + edges);
            for (int i = 0; i < edges; i++) {  // Itera para crear todas las aristas
                int u = rand.nextInt(n);  // Nodo de inicio aleatorio
                int v = rand.nextInt(n);  // Nodo de destino aleatorio
                while (v == u) v = rand.nextInt(n);  // Evita aristas de un nodo a sí mismo
                int w = 1 + rand.nextInt(1000);  // Peso aleatorio para la arista (entre 1 y 1000)
                writer.println(u + " " + v + " " + w);  // Escribe la arista en el archivo
            }

            writer.close();
            System.out.println("Archivo generado: " + filename);
        }
    }
}
