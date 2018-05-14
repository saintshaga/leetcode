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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || preorder.length != inorder.length) {
        	return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i : preorder) {
        	queue.offer(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        return buildTree(queue, map, 0, preorder.length);
    }

    private TreeNode buildTree(Queue<Integer> preorder, Map<Integer, Integer> inorder, int st, int ed) {
    	if(preorder.isEmpty() || st >= ed) {
    		return null;
    	}
    	TreeNode node = null;
    	int index = inorder.get(preorder.peek());
    	if(index >=st && index < ed) {
    		node = new TreeNode(preorder.poll());
    		node.left = buildTree(preorder, inorder, st, index);
    		node.right = buildTree(preorder, inorder, index+1, ed);
    	}
    	return node;
    }
}
