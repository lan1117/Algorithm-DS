package BinaryTreenDivideConquer;


public class MinumumDepthOfBinaryTree {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public int minDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		return helper(root);
	}
	private int helper(TreeNode root){
		if(root == null){
			return Integer.MAX_VALUE;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		return Math.min(helper(root.left), helper(root.right)) + 1;
	}
}
