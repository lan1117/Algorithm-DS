package 二刷;

public class Onetwelve_PathSum {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public boolean hasPathSum(TreeNode root, int target){
		if(root == null) return false;
		if(target - root.val == 0 && root.left == null && root.right == null) return true;
		return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
	}
}
