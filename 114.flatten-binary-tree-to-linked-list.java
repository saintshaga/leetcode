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
    	TreeNode current = root;
    	Stack<TreeNode> stack = new Stack<>();
    	Set<TreeNode> rightNodes = new HashSet<>();
    	while(current != null || !stack.isEmpty()) {
    		if(current != null) {
    			rightNodes.add(current);
    		}
    		while(current != null) {
    			stack.push(current);
    			current = current.left;
    		}
    		current = stack.pop();
    		TreeNode parent = null;
    		if(!stack.isEmpty()) {
    			parent = stack.peek();
    		}
    		if(!rightNodes.contains(current) && parent != null) {
    			TreeNode tail = current;
    			while(tail.right != null) {
    				tail = tail.right;
    			}
    			tail.right = parent.right;
    			parent.right = current;
    			parent.left = null;
    		}
    		current = current.right;
    	}
    }
}
