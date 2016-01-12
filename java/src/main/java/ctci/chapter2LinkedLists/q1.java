package ctci.chapter2LinkedLists;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static ctci.chapter2LinkedLists.LinkedListUtils.displayLinkedList;

/**
 * Created by a502219 on 6/01/2016.
 */
public class q1 {

    /*
    * Remove Dups
    *
    * Write code to remove duplicates from an unsorted linked list.
    *
    * FOLLOW UP
    *
    * How would you solve this problem if a temporary buffer is not allowed?
    *
    * Use a second pointer which for each node traverses the whole linked list to check for dups. 0(1) Memory efficient
    * but O(n) complexity
    *
    * */

    public void removeDups(Node current) {
        Set<Integer> nodeData = new HashSet<>();
        nodeData.add(current.data);
        while (current.next != null) {
            if (nodeData.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                nodeData.add(current.next.data);
            }
            current = current.next;
        }
    }


    @Test
    public void test() {
        Node node = new Node(0);
        node.next = new Node(1);
        node = node.next;
        Node head = node;
        for (int i = 1; i < 10; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        displayLinkedList(head);
        removeDups(head);
        displayLinkedList(head);
        System.out.println(LinkedListUtils.linkedListSize(head));
    }

}
