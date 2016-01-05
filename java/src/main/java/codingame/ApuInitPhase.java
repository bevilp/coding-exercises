package codingame;

import java.util.Scanner;

/**
 * ApuInitPhase
 *
 * @since 2015-11-27
 */
public class ApuInitPhase {

    public static class Node {

        int x;

        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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

            if (x != node.x) {
                return false;
            }
            return y == node.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static Node getRightNode(char[][] nodeTable, Node currentNode) {
        for (int i = currentNode.x + 1; i < nodeTable[currentNode.y].length; i++) {
            if (nodeTable[currentNode.y][i] == '0') {
                return new Node(i, currentNode.y);
            }
        }

        return new Node(-1, -1);
    }

    public static Node getDownNode(char[][] nodeTable, Node currentNode) {
        for (int i = currentNode.y + 1; i < nodeTable.length; i++) {
            if (nodeTable[i][currentNode.x] == '0') {
                return new Node(currentNode.x, i);
            }
        }

        return new Node(-1, -1);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        in.nextLine();
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();

        char[][] nodeTable = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            nodeTable[i] = line.toCharArray();
        }

        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (nodeTable[y][x] == '0') {
                    Node currentNode = new Node(x, y);
                    Node right = getRightNode(nodeTable, new Node(x, y));
                    Node down = getDownNode(nodeTable, new Node(x, y));
                    sb.append(currentNode).append(' ').append(right).append(' ').append(down).append('\n');
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(sb); // Three coordinates: a node, its right neighbor, its bottom neighbor
    }
}
