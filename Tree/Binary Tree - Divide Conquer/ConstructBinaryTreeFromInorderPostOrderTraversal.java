package BinaryTreenDivideConquer;
import java.util.*;

public class ConstructBinaryTreeFromInorderPostOrderTraversal {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    private TreeNode helper(int[] in, int is, int ie, int[] post, int ps, int pe, Map<Integer, Integer> map){
        if(is > ie || ps > pe) return null;
        
        TreeNode root = new TreeNode(post[pe]);
        int idx = map.get(post[pe]);
        root.left = helper(in, is, idx - 1, post, ps, ps + idx - 1 - is, map);
        root.right = helper(in, idx + 1, ie, post, ps + idx - is, pe - 1, map);
        
        return root;
    }
}
