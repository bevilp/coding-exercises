package ctci.chapter2LinkedLists;

import org.junit.Test;

/**
 * Created by a502219 on 6/01/2016.
 */
public class q3 {

    /*
    * Delete middle node
    *
    * Implement an algorithm to delete a node in the middle (i.e. any node but the first and last node, not
    * necessarily the exact middle) of a singly linked list, given only access to that node.
    *
    * EXAMPLE
    * Input: the node c from the linked list a->b->c->d->e->f
    * Result: nothing is returned, but the new linked list looks like: a->b->d->e->f
    *
    * */

    public void deleteNode(Node node, int nth) {
        // Not testing for nth is < linkedList.size
        if (nth <= 0) return;
        while (--nth > 0) {
            node = node.next;
        }

        node.data = node.next.data;
        node.next = node.next.next;
    }

    @Test
    public void test() {
        Node head = LinkedListUtils.generateLinkedList(10);
        deleteNode(head, 5);

        LinkedListUtils.displayLinkedList(head);
    }
}
