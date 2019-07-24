/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
    	flat(root);
    }

    private TreeNode flat(TreeNode node) {
    	if(node == null) {
    		return null;
    	}
    	TreeNode tail  = node;
    	TreeNode right = node.right;
    	if(node.left != null) {
    		tail = flat(node.left);
    		node.right = node.left;
    		node.left = null;
    		tail.right = right;
    	}
    	if(right != null) {
    		tail = flat(right);
    	}
    	return tail;
    }
}
