package ctci.chapter2LinkedLists;

/**
 * Created by Benoit Piette on 11/01/2016.
 */
public class LinkedListUtils {

    public static void displayLinkedList(Node head) {
        StringBuilder sb = new StringBuilder();
        sb.append(head.data);
        while (head.next != null) {
            sb.append("->").append(head.next.data);
            head = head.next;
        }
        System.out.println(sb);
    }

    public static int linkedListSize(Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    public static Node generateLinkedList(int size) {
        Node head = new Node(0);
        Node node = head;
        for (int i = 1; i < size; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        return head;
    }
}
