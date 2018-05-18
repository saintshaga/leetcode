/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
        	return;
        }
        if(root.left != null) {
        	if(root.right != null) {
        		root.left.next = root.right;
        	} else {
        		root.left.next = getNextNode(root.next);
        	}
        }
        if(root.right != null) {
        	root.right.next = getNextNode(root.next);
        }
        connect(root.right);
        connect(root.left);
    }

    private TreeLinkNode getNextNode(TreeLinkNode root) {
    	if(root == null) {
    		return root;
    	}
    	if(root.left != null) {
    		return root.left;
    	} else if(root.right != null) {
    		return root.right;
    	} else {
    		return getNextNode(root.next);
    	}
    }
}
