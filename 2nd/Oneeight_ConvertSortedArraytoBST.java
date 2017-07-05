package 二刷;

public class Oneeight_ConvertSortedArraytoBST {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public TreeNode sortedArrayToBST(int[] nums){
		if(nums == null || nums.length == 0) return null;
		int low = 0;
		int high = nums.length - 1;
		return helper(nums, low, high);
	}
	public TreeNode helper(int[] nums, int low, int high){
		if(low > high) return null;
		int mid = low + (high - low) / 2;
		if(low == high) return new TreeNode(nums[mid]);
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, low, mid - 1);
		node.right = helper(nums, mid + 1, high);
		return node;
	}
}
