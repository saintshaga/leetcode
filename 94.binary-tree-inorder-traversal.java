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
    	List<Integer> result = new ArrayList<>();
        if(root == null) {
        	return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode peek = stack.peek();
        	if(peek.left != null) {
        		stack.push(peek.left);
        		peek.left = null;
        	} else {
        		stack.pop();
        		result.add(peek.val);
        		if(peek.right != null) {
        			stack.push(peek.right);
        		}
        	}
        }
        // result.addAll(inorderTraversal(root.left));
        // result.add(root.val);
        // result.addAll(inorderTraversal(root.right));
        return result;
    }
}
