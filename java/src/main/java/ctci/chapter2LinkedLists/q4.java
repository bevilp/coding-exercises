package ctci.chapter2LinkedLists;

import java.util.Random;

/**
 * Created by a502219 on 6/01/2016.
 */
public class q4 {

    /*
    * Partition
    *
    * Write code to partition a linked list around a value x, such that all nodes less than x come
    * before all nodes greater or equal to x. If x is contained within the list, the values of x only need to be
    * after the elements less than x (see below). The partition element x can appear anywhere in the "right
    * partition"; it does not need to appear between the left and right partition.
    *
    * EXAMPLE
    * Input: 3->5->8->5->10->2->1 (Partition=5)
    * Output: 3->1->2->10->5->5->8
    *
    * */
    public static Node partition(int value, Node node) {
        Node head = node;
        Node tail = node;

		/* Partition list */
        while (node != null) {
            Node next = node.next;
            if (node.data < value) {
                /* Insert node at head. */
                node.next = head;
                head = node;
            } else {
				/* Insert node at tail. */
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node node = first;

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            node.next = new Node(rand.nextInt(20));
            node = node.next;
        }
        displayList(first);
        Node head = partition(5, first);
        displayList(head);
    }

    public static void displayList(Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.data);
        while (node.next != null) {
            sb.append("->").append(node.data);
            node = node.next;
        }
        System.out.println(sb);
    }
}
