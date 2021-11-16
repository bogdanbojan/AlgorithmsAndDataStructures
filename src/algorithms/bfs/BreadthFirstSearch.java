package algorithms.bfs;
import java.lang.reflect.Array;
import java.util.*;
import algorithms.bfs.Graph;



public class BreadthFirstSearch {

    BreadthFirstSearch (Graph g, int s)
    {
        boolean[] explored = new boolean[g.getGraphSize()];
        explored[s] = true;
        List<List<Integer>> adjList = g.adjList; // too look cleaner

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);

        while(!queue.isEmpty())
        {
            int v = queue.poll(); // using v,w to represent the source and dest of an edge
            for (int i=0; i < adjList.get(v).size(); i++)
            {
                int w = adjList.get(v).get(i);
                if(!explored[w])
                {
                    explored[w] = true;
                    queue.add(w);
                }
            }

        }


    }



    public static void main (String[] args)
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.printGraph();


    }


}