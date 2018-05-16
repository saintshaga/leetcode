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

    	flattenWithReturn(root);
    }
    private TreeNode flattenWithReturn(TreeNode root) {
    	if(root == null) {
    		return null;
    	}
    	if(root.left == null && root.right == null) {
    		return root;
    	} else if(root.left == null) {
    		return flattenWithReturn(root.right);
    	}
    	TreeNode last = flattenWithReturn(root.left);
    	last.right = root.right;
    	root.right = root.left;
    	root.left = null;
    	return last.right == null ? last : flattenWithReturn(last.right);
    }
}
