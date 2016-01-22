package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

/**
 * InverseTree
 *
 * @since 2015-11-04
 */
@SuppressWarnings("Duplicates")
public class InverseTree {

    private void LevelOrder(Node root) {
        if (root == null) {
            return;
        }
        Deque<Node> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(root);

        while (!nodesToVisit.isEmpty()) {
            Node node = nodesToVisit.remove();
            System.out.print(node.data + " ");
            if (null != node.left) {
                nodesToVisit.add(node.left);
            }
            if (null != node.right) {
                nodesToVisit.add(node.right);
            }
        }
    }

    void Invert(Node root) {
        if (root == null) {
            return;
        }
        Invert(root.left);
        Invert(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    @Test
    public void InvertTest() {
        Node root1 = getPremadeTree();
        LevelOrder(root1);
        Invert(root1);
        System.out.println("");
        LevelOrder(root1);
    }

    public Node getPremadeTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;

        return node4;
    }

}
