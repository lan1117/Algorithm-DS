package BinaryTreenDivideConquer;
//Given a binary tree, find the length of the longest consecutive sequence path.
//The path could be start and end at any node in the tree

public class BinaryTreeLongestConsecutiveSequenceII {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	public class ResultType{
		int max_up;
		int max_down;
		int max_length;
		ResultType(int len, int down, int up){
			max_length = len;
			max_down = down;
			max_up = up;
		}
	}
	public int longestConsecutive2(TreeNode root){
		return helper(root).max_length;
	}
	private ResultType helper(TreeNode root){
		//base case
		if(root == null){
			return new ResultType(0, 0, 0);
		}
		
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		int up = 0;
		int down = 0;
		if(root.left != null && root.left.val + 1 == root.val){
			down = Math.max(down, left.max_down + 1);
		}
		if(root.left != null && root.left.val == root.val + 1){
			up = Math.max(up, left.max_up + 1);
		}
		if(root.right != null && root.right.val + 1 == root.val){
			down = Math.max(down, right.max_down + 1);
		}
		if(root.right != null && root.right.val == root.val + 1){
			up = Math.max(up, right.max_up + 1);
		}
		int len = down + 1 + up;
		len = Math.max(len, Math.max(left.max_length, right.max_length));
		return new ResultType(len, down, up);
		
	}
	
}
