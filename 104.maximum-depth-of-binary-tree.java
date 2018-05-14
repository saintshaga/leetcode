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
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				TreeNode p = queue.poll();
				if(p.left != null) {
					queue.offer(p.left);
				}
				if(p.right != null) {
					queue.offer(p.right);
				}
			}
			count++;
		}
		return count;
	}
    public int maxDepth2(TreeNode root) {
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
