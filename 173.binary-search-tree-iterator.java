/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

	private Stack<TreeNode> stack;
	private TreeNode current;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        current = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        while(current != null) {
        	stack.push(current);
        	current = current.left;
        }
        current = stack.pop();
        int val = current.val;
        current = current.right;
        return val;

    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
