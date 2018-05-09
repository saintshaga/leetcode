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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
    	if(node == null) {
    		return true;
    	}
    	if(min != null && node.val <= min) {
    		return false;
    	}
    	if(max != null && node.val >= max) {
    		return false;
    	}
    	if(node.left != null && node.left.val >= node.val) {
    		return false;
    	}
    	if(node.right != null && node.right.val <= node.val) {
    		return false;
    	}
    	return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
