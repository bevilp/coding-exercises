package ctci.chapter4TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Node
 *
 * @since 2016-01-18
 */
public class Node {

    public int data;

    public Set<Node> adjacentNodes = new HashSet<>();

    boolean visited = false;

    public Node() {
    }

    public Node(int data) {

        this.data = data;
    }

    void addAdjacentNode(Node node) {
        this.adjacentNodes.add(node);
    }

    boolean hasAdjacentNode(Node node) {
        return this.adjacentNodes.contains(node);
    }
}
