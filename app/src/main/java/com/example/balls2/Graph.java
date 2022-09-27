package com.example.balls2;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    // Создание графа
    Graph(int vertices) {
        //rebra
        adjLists = new LinkedList[vertices];
        //visited
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    // Добавление ребер
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // Алгоритм
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        // stack tipa
        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal");

        g.DFS(2);
    }
}

