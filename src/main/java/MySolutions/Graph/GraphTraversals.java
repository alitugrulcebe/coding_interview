package MySolutions.Graph;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;



public class GraphTraversals {
  static Set<String> depthFirstTraversal(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<String>();
    Stack<String> stack = new Stack<String>();
    stack.push(root);
    while (!stack.isEmpty()) {
      String vertex = stack.pop();
      if (!visited.contains(vertex)) {
        visited.add(vertex);
        for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
          stack.push(v.label);
        }
        System.out.print(vertex + " -> ");
      }
    }
    return visited;
  }

  static Set<String> breadthFirstTraversal(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<String>();
    Queue<String> queue = new LinkedList<String>();
    queue.add(root);
    visited.add(root);
    while (!queue.isEmpty()) {
      String vertex = queue.poll();
      System.out.print(vertex + " -> ");
      for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
        if (!visited.contains(v.label)) {
          visited.add(v.label);
          queue.add(v.label);
        }
      }
    }
    return visited;
  }

  public static void main(String[] args) {
    Graph g = new Graph();
    g.addVertex("A");
    g.addVertex("B");
    g.addVertex("C");
    g.addVertex("D");
    g.addVertex("E");
    g.addVertex("F");
    g.addVertex("G");
    g.addVertex("H");
    g.addVertex("I");
    g.addEdge("A","B");
    g.addEdge("A","C");
    g.addEdge("A","F");
    g.addEdge("B","F");
    g.addEdge("C","G");
    g.addEdge("C","F");
    g.addEdge("F","H");
    g.addEdge("G","H");

    g.addEdge("D","E");
    g.addEdge("D","I");
    g.addEdge("E","I");


    depthFirstTraversal(g,"D");
    System.out.println();
    breadthFirstTraversal(g,"D");


  }
}
