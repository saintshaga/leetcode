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
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        int[] reversePostorder = new int[postorder.length];
        for(int i=0; i<postorder.length; i++) {
        	reversePostorder[i] = postorder[postorder.length - i -1];
        }
        return buildTree(inorder, 0, inorder.length, reversePostorder, 0, reversePostorder.length, map);
    }

    private TreeNode buildTree(int[] inorder, int sti, int edi, int[] reversePostorder, int stp, int edp, Map<Integer, Integer> map) {
    	if(sti >= edi || stp >= edp || sti < 0 || stp < 0 || edi > inorder.length || edp > reversePostorder.length) {
    		return null;
    	}
    	int rootVal = reversePostorder[stp];
    	int indexInorder = map.get(rootVal);
    	TreeNode root = new TreeNode(rootVal);
    	root.right = buildTree(inorder, indexInorder+1, edi, reversePostorder, stp+1, stp+edi-indexInorder, map);
    	root.left = buildTree(inorder, sti, indexInorder, reversePostorder, stp+edi-indexInorder, stp+edi-sti, map);
    	return root;
    }
}
