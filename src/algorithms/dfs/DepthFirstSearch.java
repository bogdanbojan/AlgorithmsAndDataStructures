package algorithms.dfs;
import algorithms.bfs.Graph;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    public void iterativeDFS(Graph g, int s)
    {
        boolean[] explored = new boolean[g.getGraphSize()];
//        explored[s] = true;
        List<List<Integer>> adjList = g.adjList;

        Stack<Integer> stack = new Stack<>();
        stack.add(s);


        while (!stack.isEmpty())
        {
            int v = stack.pop();
            if (!explored[v]) explored[v] = true;

            for (int i=0; i < adjList.get(v).size(); i++)
            {
                int w = adjList.get(v).get(i);
                if(!explored[w])
                {
                    stack.push(w);
                }
            }

        }

    }



    public static void recursiveDFS(Graph g, int s, boolean[] exploredR)
    {

        exploredR[s] = true;
        for (int w: g.adjList.get(s))
        {
            if (!exploredR[w])
            {
                recursiveDFS(g, w, exploredR);
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

        boolean[] exploredR = new boolean[g.getGraphSize()];

        // Perform DFS traversal from all undiscovered nodes to
        // cover all connected components of a graph
        for (int i = 0; i < g.getGraphSize(); i++)
        {
            if (!exploredR[i]) {
                recursiveDFS(g, i, exploredR);
            }
        }

    }
}
