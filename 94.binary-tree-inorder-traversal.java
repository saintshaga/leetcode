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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> results = new ArrayList<>();
        if(root == null) {
        	return results;
        }
        TreeNode current = root;
        stack.push(root);
        while(current != null || !stack.isEmpty()) {
        	if(current != null) {
        		current = current.left;
        		if(current != null) {
        			stack.push(current);
        		}
        	} else {
        		current = stack.pop();
        		results.add(current.val);
        		if(current.right != null) {
        			current = current.right;
        			stack.push(current);
        		} else {
        			current = null;
        		}
        	}
        }
        return results;
    }
}
