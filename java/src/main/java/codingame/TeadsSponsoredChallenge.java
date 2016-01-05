package codingame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TeadsSponsoredChallenge
 *
 * @since 2015-11-27
 */
public class TeadsSponsoredChallenge {

    public static class Node {

        int num;

        Set<Node> adjacentNodes;

        public Node(int num) {
            this.num = num;
            this.adjacentNodes = new HashSet<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node node = (Node) o;

            return num == node.num;

        }

        @Override
        public int hashCode() {
            return num;
        }
    }

    public static void main(String args[]) {
        Set<Node> nodeSet = new HashSet<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of adjacency relations
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(); // the ID of a person which is adjacent to yi
            int yi = in.nextInt(); // the ID of a person which is adjacent to xi
            Node nodeX = new Node(xi);
            Node nodeY = new Node(yi);
            if (!nodeSet.contains(nodeX)) {
                nodeSet.add(nodeX);
            }
            if (!nodeSet.contains(nodeY)) {
                nodeSet.add(nodeY);
            }
            nodeX.adjacentNodes.add(nodeY);
        }








        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("1"); // The minimal amount of steps required to completely propagate the advertisement
    }

}
