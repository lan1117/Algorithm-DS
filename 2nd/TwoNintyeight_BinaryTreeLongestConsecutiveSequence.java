package 二刷;

public class TwoNintyeight_BinaryTreeLongestConsecutiveSequence {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	int len = 0;
	public int longestConsecutive(TreeNode root){
		//len = 0;
		helper(root);
		return len;
	}
	public int helper(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		
		int longestsubtree = 1;
		if(root.left != null && root.val + 1 == root.left.val){
			longestsubtree = Math.max(longestsubtree, left + 1);
		}
		if(root.right != null && root.val + 1 == root.right.val){
			longestsubtree = Math.max(longestsubtree, right + 1);
		}
		if(longestsubtree > len){
			len = longestsubtree;
		}
		return longestsubtree;
	}
}
