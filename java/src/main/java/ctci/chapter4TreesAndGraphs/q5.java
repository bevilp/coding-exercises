package ctci.chapter4TreesAndGraphs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Benoit Piette on 6/01/2016.
 */
public class q5 {

    /*
    * Validate BST
    *
    * Implement a function to check if a binary tree is a binary search tree
    *
    * */
    public boolean isBST(BinaryTreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }

        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }
      /*
         20
        /  \
      10    30
           /  \
          29    40
      */
    @Test
    public void validTreeTest() {
        BinaryTreeNode n20 = new BinaryTreeNode(20);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n30 = new BinaryTreeNode(30);
        BinaryTreeNode n29 = new BinaryTreeNode(29);
        BinaryTreeNode n40 = new BinaryTreeNode(40);
        n20.left = n10;
        n20.right = n30;
        n30.left = n29;
        n30.right = n40;

        Assert.assertTrue(isBST(n20, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    /*
         20
        /  \
      10    30
           /  \
          5    40
      */
    @Test
    public void notValidTreeTest() {
        BinaryTreeNode n20 = new BinaryTreeNode(20);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        BinaryTreeNode n30 = new BinaryTreeNode(30);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n40 = new BinaryTreeNode(40);
        n20.left = n10;
        n20.right = n30;
        n30.left = n5;
        n30.right = n40;

        Assert.assertFalse(isBST(n20, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
