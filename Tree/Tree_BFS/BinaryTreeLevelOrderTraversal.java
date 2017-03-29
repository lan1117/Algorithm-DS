package BFS;
import java.util.*;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
public class BinaryTreeLevelOrderTraversal {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			ArrayList<Integer> level = new ArrayList<>();
			int size = queue.size();
			for(int i = 0; i < size; i ++){
				TreeNode head = queue.poll();
				level.add(head.val);
				if(head.left != null){
					queue.offer(head.left);
				}
				if(head.right != null){
					queue.offer(head.right);
				}
			}
			res.add(level);
		}
		return res;
	}
}
