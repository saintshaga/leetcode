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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
        	while(current != null) {
        		stack.push(current);
        		current = current.left;
        	}
   		    current = stack.pop();
        	index++;
        	if(index == k) {
        		return current.val;
        	}
        	current = current.right;
        }
	    return -1;
    }
}
