package 二刷;

public class Nintyeight_ValidateBinarySearchTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	private TreeNode prev = null;
	private int lastVal = Integer.MIN_VALUE;
	public boolean validTree(TreeNode root){
		if(root == null) return true;
		if(!validTree(root.left)) return false;
		if(prev != null && lastVal >= root.val) return false;
		
		prev = root;
		lastVal = root.val;
		if(!validTree(root.right)) return false;
		return true;
		
	}
}
