package 二刷;

public class ThreeThrityseven_HouseRobberIII {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public int rob(TreeNode root){
		if(root == null){
			return 0;
		}
		int[] ans = helper(root);
		return Math.max(ans[0], ans[1]);
	}
	public int[] helper(TreeNode root){
		if(root == null) return new int[2];
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		
		int[] res = new int[2];
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = left[0] + right[0] + root.val;
		
		return res;
	}
}
