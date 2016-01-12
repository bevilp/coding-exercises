package ctci.chapter2LinkedLists;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by a502219 on 6/01/2016.
 */
public class q2 {

    /*
    * Return the Kth to last element
    *
    * Implement an algorithm to find the kth to last element of a singly linked list
    *
    */


    public Node kthNode(Node head, int k) {
        //TODO
        return null;
    }

    @Test
    public void test() {
        Node head = LinkedListUtils.generateLinkedList(10);
        Node kth = kthNode(head, 2);
        assertEquals(7, kth.data);
        System.out.println(kth.data);
        LinkedListUtils.displayLinkedList(head);
    }
}
