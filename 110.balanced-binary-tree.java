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
    public boolean isBalanced(TreeNode root) {
    	return height(root) >= 0;
    }

    private int height(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	int left = height(root.left);
    	int right = height(root.right);
    	int h = Math.max(Math.abs(left), Math.abs(right)) + 1;
    	boolean balanced = left >= 0 && right >=0 && Math.abs(left-right) <= 1;
    	return balanced ? h : -h;
    }

    public static class NodeInfo {
    	boolean isBalanced;
    	int height;
    	NodeInfo(boolean b, int h) {
    		isBalanced = b;
    		height = h;
    	}
    }
}
