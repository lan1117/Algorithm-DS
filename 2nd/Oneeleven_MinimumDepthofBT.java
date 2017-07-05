package 二刷;

public class Oneeleven_MinimumDepthofBT {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public int MinimumDepth(TreeNode root){
		if(root == null) return 0;
		int left = MinimumDepth(root.left);
		int right = MinimumDepth(root.right);
		return (left == 0 || right == 0) ? left+right+1 : Math.min(left, right) + 1;
 	}
}
