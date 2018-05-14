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
    public int maxDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        int maxDepth = 0;
        stack.push(root);
        depth.push(1);
        while(!stack.isEmpty()) {
        	TreeNode p = stack.pop();
        	int d = depth.pop();
        	maxDepth = Math.max(maxDepth, d);
        	if(p.right != null) {
        		stack.push(p.right);
        		depth.push(d+1);
        	}
        	if(p.left != null) {
        		stack.push(p.left);
        		depth.push(d+1);
        	}
        }
        return maxDepth;
    }

}
