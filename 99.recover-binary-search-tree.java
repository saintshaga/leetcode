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
    public void recoverTree(TreeNode root) {
        if(root == null) {
        	return;
        }
        List<Integer> inOrder = new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()) {
        	while(curr != null) {
        		stack.push(curr);
        		curr = curr.left;
        	}
        	curr = stack.pop();
        	inOrder.add(curr.val);
        	curr = curr.right;
        }

        Collections.sort(inOrder);
        int i=0;
        curr = root;
        while(curr != null || !stack.isEmpty()) {
        	while(curr != null) {
        		stack.push(curr);
        		curr = curr.left;
        	}
        	curr = stack.pop();
        	curr.val = inOrder.get(i++);
        	curr = curr.right;
        }
    }
}
