package BFS;
import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		dfs(root, res, 0);
		return res;
	}
	private void dfs(TreeNode root, List<List<Integer>> res, int level){
		if(root == null){
			return;
		}
		if(level >= res.size()){
			res.add(new LinkedList<>());
		}
		if(level % 2 == 0){
			res.get(level).add(root.val);
		}
		else{
			res.get(level).add(0, root.val);
		}
		dfs(root.left, res, level + 1);
		dfs(root.right, res, level + 1);
	}
}
