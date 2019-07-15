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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> results = new LinkedList<>();
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || !stack.isEmpty()) {
        	while(current != null) {
        		stack.push(current);
        		results.addFirst(current.val);
        		current = current.right;
        	}
        	current = stack.pop();
        	current = current.left;
        }
        return results;
    }

}
