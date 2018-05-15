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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || inorder.length != postorder.length) {
        	return null;
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int st1, int ed1, int[] postorder, int st2, int ed2) {
    	if(st1 > ed1 || st2 > ed2) {
    		return null;
    	}
    	TreeNode node = new TreeNode(postorder[ed2]);
    	int index = -1;
    	for(int i=st1; i<=ed1; i++) {
    		if(inorder[i] == node.val) {
    			index = i;
    			break;
    		}
    	}
    	if(index < 0) {
    		return null;
    	}
    	node.left = buildTree(inorder, st1, index-1, postorder, st2, st2+index-st1-1);
    	node.right = buildTree(inorder, index+1, ed1, postorder, st2+index-st1, ed2-1);
    	return node;
    }
}
