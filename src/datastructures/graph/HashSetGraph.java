package datastructures.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HashSetGraph <T>
{

    Map<T, LinkedList<T>> map = new HashMap<>(); // [1 --> 2, 2]
   public void addVertex (T vertex)
   {
       if (!map.containsKey(vertex)) {
           map.put(vertex, new LinkedList<>());
       }
       else {
           System.out.println("The vertex " + vertex + " already exists.");
       }
   }

    public void addEdge (T source,
                         T dest,
                         boolean undirected)
    {
        if (!map.containsKey(source))
        {
            addVertex(source);
        }

        if (!map.containsKey(dest))
        {
            addVertex(dest);
        }

        map.get(source).add(dest);
        if (undirected)
        {
            map.get(dest).add(source);
        }
    }

    public int getVertexCount()
    {
        return map.size();
    }

    public int getEdgeCount(boolean undirected)
    {
        int count = 0;
        for (T vertex: map.keySet()) {
            count += map.get(vertex).size();
        }
        if (undirected)
        {
            count /= 2;
        }
    
        return count;
    }

    public boolean hasVertex(T vertex)
    {
        return map.containsKey(vertex);
    }


    public boolean hasEdge(T source, T dest)
    {
        return map.get(source).contains(dest);
    }

    public void printGraph()
    {
        for (T vertex: map.keySet())
        {
            System.out.print(vertex + ": ");
            for (T adjVertex: map.get(vertex))
            {
                System.out.print(adjVertex + " ");
            }
            System.out.println();
        }

    }

    public static void main (String[] args) {
       HashSetGraph<Integer> graph = new HashSetGraph<>();
       graph.addEdge(1,2, false);
       graph.addEdge(1,3, false);
       graph.addEdge(2,4, false);
       graph.addEdge(4,5, false);
       graph.addVertex(6);

       graph.printGraph();


    }
}
