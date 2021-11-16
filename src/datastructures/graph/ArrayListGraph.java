package datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Edge
{
    int source;
    int dest;

    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}


// 1--->2--->3
// [1 | ] -> [2,4]
// [2 | ] -> [3]
// [3 | ]

class Graph
{

    List<List<Integer>> adjList;

    public Graph (List<Edge> edges)
    {
        adjList = new ArrayList<>();

        for (Edge e: edges) // use integer.max to see how many array lists to create. if you have (1,2)(1,3) u only need one.
        {
            adjList.add(new ArrayList<>());
        }

        for (Edge e: edges)
        {
            adjList.get(e.source).add(e.dest);
        }

    }

    public static void printGraph(Graph graph)
    {
        int i = 0;
        int n = graph.adjList.size();


        while (i < n){
            for (int j: graph.adjList.get(i))
            {
                System.out.print(i + " -> " + j + "\t");
            }
            System.out.println();
            i++;
    }

    }

}

public class ArrayListGraph
{

    public static void main (String[] args) {
        // Input: List of edges in a digraph (as per the above diagram)
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));

        Graph graph = new Graph(edges);
        Graph.printGraph(graph);

    }
}