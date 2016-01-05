import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringJoiner;

/**
 * BinarySearchTree
 *
 * @since 2015-11-18
 */
public class BinarySearchTree<T> {

    Comparator<T> comparator;

    private class Node {

        Node left;

        Node right;

        Node parent;

        T data;

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    private Node root;

    public void add(T data) {
        root = add(data, root);
    }

    private Node add(T data, Node root) {
        if (root == null) {
            Node node = new Node();
            node.data = data;
            return node;
        }
        if (compareTo(data, root.data) < 0) {
            root.left = add(data, root.left);
        } else {
            root.right = add(data, root.right);
        }
        return root;
    }

    @Override
    public String toString() {
        String result;
        StringJoiner sj = new StringJoiner(",");
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            Node node = deque.remove();
            sj.add(node.toString());
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
        return sj.toString();
    }

    private int compareTo(T data1, T data2) {
        if (comparator != null) {
            return comparator.compare(data1, data2);
        }

        return ((Comparable) data1).compareTo(((Comparable) data2));
    }

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.add("a");
        bst.add("d");
        bst.add("g");
        bst.add("j");
        bst.add("l");
        bst.add("c");
        bst.add("b");
        bst.add("f");
        System.out.println(bst);

    }
}

