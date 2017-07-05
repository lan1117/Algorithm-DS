package 二刷;
import java.util.*;
public class ThreeSixtysix_FindLeavesOfBinaryTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public List<List<Integer>> findLeaves(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		help(root, res);
		return res;
	}
	public int help(TreeNode root, List<List<Integer>> res){
		if(root == null) return -1;
		int height = 1+ Math.max(help(root.left, res), help(root.right, res));
		if(res.size() < height + 1){
			res.add(new ArrayList<>());
		}
		res.get(height).add(root.val);
		return height;
	}
}
