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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        TreeNode current = root;
        Stack<TreeNode> stack =  new Stack<>();
        while(current != null || !stack.isEmpty()) {
        	while(current !=  null) {
        		results.add(current.val);
        		stack.push(current);
        		current = current.left;
        	}
        	current = stack.pop();
        	current = current.right;
        }
        return results;
    }
}
