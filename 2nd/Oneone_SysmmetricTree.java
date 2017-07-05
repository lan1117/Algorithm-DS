package 二刷;

public class Oneone_SysmmetricTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public boolean isSymmetric(TreeNode root){
		return root == null || isSymmetrichelp(root.left, root.right);
	}
	public boolean isSymmetrichelp(TreeNode left, TreeNode right){
		if(left == null && right == null){
			return true;
		}
		if(left == null || right == null) return false;
		if(left.val != right.val) return false;
		return isSymmetrichelp(left.left, right.right) && isSymmetrichelp(left.right, right.left);
	}
}
