package BinaryTreenDivideConquer;
import java.util.*;

public class ConstructBinaryTreeFromPreorderInorderTraversal {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public TreeNode buildTree(int[] preorder, int[] inorder){
		if(preorder == null || inorder == null){
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i ++){
			map.put(inorder[i], i);
		}
		return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);
	}
	//is:inorder start;
	//ie: inorder end;
	private TreeNode helper(int[] in, int is, int ie, int[] pre, int ps, int pe, Map<Integer, Integer> map){
		if(is > ie || ps > pe){
			return null;
		}
		
		TreeNode root = new TreeNode(pre[ps]);
		int idx = map.get(pre[ps]);
		root.left = helper(in, is, idx - 1, pre, ps + 1, pe + idx - is, map);
		root.right = helper(in, idx + 1, ie, pre, ps + idx - is + 1, pe, map);
		return root;		
	}
}
