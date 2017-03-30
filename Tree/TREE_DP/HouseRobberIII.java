package Tree_DP;


public class HouseRobberIII {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public int rob(TreeNode root){
		if(root == null){
			return 0;
		}
		int[] ans = helper(root);
		return Math.max(ans[0], ans[1]);
	}
	private int[] helper(TreeNode root){
		if(root == null){
			return new int[2];
		}
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		
		int[] res = new int[2];
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = left[0] + right[0] + root.val;
		return res;
	}
}
