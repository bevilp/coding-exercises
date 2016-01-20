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
        Node node1 = new Node(1);
        node1.addAdjacentNode(new Node(2));
        node1.addAdjacentNode(new Node(3));
        node1.addAdjacentNode(new Node(4));
        Node node4 = new Node(5);
        // node1.addAdjacentNode(node4);
        Node node2 = new Node(6);
        node4.addAdjacentNode(node2);
        System.out.println(BFSSearch(node1, node2));
    }

    public static boolean BFSSearch(Node root, Node searched) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            node.visited = true;
            if (node.equals(searched)) {
                return true;
            }
            // get only the nodes which haven't been visited yet in order to avoid cycles.
            node.adjacentNodes.parallelStream().filter(node1 -> !node.visited).forEach(node2 -> queue.add(node2));
            queue.addAll(node.adjacentNodes);
        }
        return false;
    }
}
