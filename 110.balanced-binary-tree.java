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
    	return balanceAndHeight(root).isBalanced;
    }

    private NodeInfo balanceAndHeight(TreeNode root) {
    	if(root == null) {
    		return new NodeInfo(true, 0);
    	}
    	NodeInfo left = balanceAndHeight(root.left);
    	NodeInfo right = balanceAndHeight(root.right);
    	return new NodeInfo(left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) <= 1), Math.max(left.height, right.height) + 1);
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
