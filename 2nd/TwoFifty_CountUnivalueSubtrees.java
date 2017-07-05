package 二刷;

public class TwoFifty_CountUnivalueSubtrees {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	int res = 0;
	public int countUnivalSubtrees(TreeNode root){
		if(root == null) return 0;
		helper(root);
		return res;
	}
	public boolean helper(TreeNode root){
		if(root == null) return true;
		boolean left = helper(root.left);
		boolean right = helper(root.right);
		if(left & right){
			if(root.left != null && root.left.val != root.val){
				return false;
			}
			if(root.right != null && root.right.val != root.val){
				return false;
			}
			res++;
			return true;
		}
		return false;
	}
}
