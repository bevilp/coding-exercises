package ctci.chapter2LinkedLists;

/**
 * Created by Benoit Piette on 11/01/2016.
 */
public class Node {

    int data;

    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }


}
