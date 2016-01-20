package ctci.chapter4TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by a502219 on 6/01/2016.
 */
public class q1 {

    /*
    *
    * Route between nodes
    *
    * Given a directed graph, design an algorithm to find out whether there is a route between nodes.
    *
    * */

    public static void main(String[] args) {
        GraphNode graphNode1 = new GraphNode(1);
        graphNode1.addAdjacentNode(new GraphNode(2));
        graphNode1.addAdjacentNode(new GraphNode(3));
        graphNode1.addAdjacentNode(new GraphNode(4));
        GraphNode graphNode4 = new GraphNode(5);
        // graphNode1.addAdjacentNode(graphNode4);
        GraphNode graphNode2 = new GraphNode(6);
        graphNode4.addAdjacentNode(graphNode2);
        System.out.println(BFSSearch(graphNode1, graphNode2));
    }

    public static boolean BFSSearch(GraphNode root, GraphNode searched) {
        Deque<GraphNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            GraphNode graphNode = queue.pop();
            graphNode.visited = true;
            if (graphNode.equals(searched)) {
                return true;
            }
            // get only the nodes which haven't been visited yet in order to avoid cycles.
            graphNode.adjacentGraphNodes.parallelStream().filter(node1 -> !graphNode.visited).forEach(node2 -> queue.add(node2));
            queue.addAll(graphNode.adjacentGraphNodes);
        }
        return false;
    }
}
