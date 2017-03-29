package BinaryTreenDivideConquer;
import java.util.*;
//Your are given a binary tree in which each node contains a value.
//Design an algorithm to get all paths which sum to a given value. 
//The path does not need to start or end at the root or a leaf, but it must go in a straight line down.

public class BinaryTreePathSumII {
	 public class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	          this.val = val;
	          this.left = this.right = null;
	      }
	 }
	 public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target){
		 List<List<Integer>> res = new ArrayList<>();
		 ArrayList<Integer> buffer = new ArrayList<>();
		 if(root == null){
			 return res;
		 }
		 findSum(root, target, buffer, 0, res);
		 return res;
	 }
	 private void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level, List<List<Integer>> res){
		 if(head == null){
			 return;
		 }
		 int tmp = sum;
		 buffer.add(head.val);
		 for(int i = level; i >= 0; i --){
			 tmp -= buffer.get(i);
			 if(tmp == 0){
				 List<Integer> temp = new ArrayList<Integer>();
				 for(int j = i; j <= level; j ++){
					 temp.add(buffer.get(j));
				 }
				 res.add(temp);
			 }
		 }
		 findSum(head.left, sum, buffer, level + 1, res);
		 findSum(head.right, sum, buffer, level + 1, res);
		 buffer.remove(buffer.size() - 1);
	 }
}
