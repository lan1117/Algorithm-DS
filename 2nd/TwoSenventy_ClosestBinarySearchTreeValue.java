package 二刷;

public class TwoSenventy_ClosestBinarySearchTreeValue {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public int closestValue(TreeNode root, double target){
		int a = root.val;
		TreeNode kid = target > a ? root.right : root.left;
		if(kid == null){
			return a;
		}
		int b = closestValue(kid, target);
		return Math.abs(b - target) > Math.abs(a - target) ? a : b;
	}
}
