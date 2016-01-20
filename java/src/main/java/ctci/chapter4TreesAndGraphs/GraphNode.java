package ctci.chapter4TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;

/**
 * GraphNode
 *
 * @since 2016-01-18
 */
public class GraphNode {

    public int data;

    public Set<GraphNode> adjacentGraphNodes = new HashSet<>();

    boolean visited = false;

    public GraphNode() {
    }

    public GraphNode(int data) {

        this.data = data;
    }

    void addAdjacentNode(GraphNode graphNode) {
        this.adjacentGraphNodes.add(graphNode);
    }

    boolean hasAdjacentNode(GraphNode graphNode) {
        return this.adjacentGraphNodes.contains(graphNode);
    }
}
