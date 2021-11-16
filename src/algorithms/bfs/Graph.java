package algorithms.bfs;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    public  int vertices;
    public  List<List<Integer>> adjList;

    public Graph(int vertices)
    {
        this.vertices = vertices;
        adjList = new LinkedList<>();
        for (int i=0; i < vertices; i++)
        {
            adjList.add(new LinkedList<>());
        }


    }

    public int getGraphSize()
    {
        return adjList.size();
    }


    public void addEdge(int source, int dest) {
//        if (!adjList.get(source).contains(dest)) {
//            adjList.get(source).add(dest);
//        }
//        // || adjList[source].add(dest).
//        if (!adjList.get(dest).contains(source)) {
//            adjList.get(dest).add(source);
//        }

        adjList.get(source).add(dest);

    }
    public void printGraph()
    {
        for (int i=0; i < adjList.size(); i++ )
        {
            System.out.print(i + " -> ");
            for (int element: adjList.get(i))
            {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
//    public static void main (String[] args)
//    {
//        Graph g = new Graph(4);
//
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
//
//        g.printGraph();
//    }
}



