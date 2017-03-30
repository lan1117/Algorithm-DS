package BFS;
//Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
import java.util.*;

public class FindModeInBianrySearchTree {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	public TreeNode prev = null;
	public int max = 0;
	public int count = 1;
	public int[] findMode(TreeNode root){
		if(root == null){
			return new int[0];
		}
		List<Integer> list = new ArrayList<>();
		helper(root, list);
		int n = list.size();
		int[] res = new int[n];
		for(int i = 0; i < n; i ++){
			res[i] = list.get(i);
		}
		return res;
	}
	private void helper(TreeNode root, List<Integer> list){
		if(root == null){
			return;
		}
		helper(root.left, list);
		if(prev != null){
			if(prev.val == root.val){
				count ++;
			}
			else{
				count = 1;
			}
		}
		if(max < count){
			max = count;
			list.clear();
			list.add(root.val);
		}
		if(max == count){
			list.add(root.val);
		}
		prev = root;
		helper(root.right, list);
	}
}
