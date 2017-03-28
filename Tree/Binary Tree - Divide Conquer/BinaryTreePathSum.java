package BinaryTreenDivideConquer;
import java.util.*;
//Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

//A valid path is from root node to any of the leaf nodes.

public class BinaryTreePathSum {
	 public class TreeNode {
		      public int val;
		      public TreeNode left, right;
		      public TreeNode(int val) {
		          this.val = val;
		          this.left = this.right = null;
		      }
		  }
	 public List<List<Integer>> binaryTreePathSum(TreeNode root, int target){
		 List<List<Integer>> res = new ArrayList<>();
		 List<Integer> path = new ArrayList<>();
		 //int sum = root.val;
		 path.add(root.val);
		 helper(root, root.val, path, res, target);
		 return res;
	 }
	 private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res, int target){
		 //base case
		 if(root.left == null && root.right == null){
			 if(sum == target){
				 res.add(new ArrayList<Integer>(path));
			 }
			 return;
		 }
		 
		 //go left
		 if(root.left != null){
			 path.add(root.left.val);
			 helper(root.left, sum + root.left.val, path, res, target);
			 path.remove(path.size() - 1);//if the last one is not satisfied the requirement, then need to consider the right node. 
			 //if the last one is statisfied the requirement, we still need to delete the last node since we need to consider the right node case.
		 }
		 
		 //go right
		 if(root.right != null){
			 path.add(root.right.val);
			 helper(root.right, sum + root.right.val, path, res, target);
			 path.remove(path.size() - 1);
		 }
	 }
}
