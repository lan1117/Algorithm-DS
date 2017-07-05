package 二刷;
import java.util.*;
public class Onethirteen_PathSumii {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		if(root == null) return res;
		path.add(root.val);
		int cur = root.val;
		helper(root, path, res, cur, sum);
		return res;
	}
	public void helper(TreeNode root,  List<Integer> path, List<List<Integer>> res, int cur, int sum){
		if(root.left == null && root.right == null){
			if(cur == sum){
				res.add(new ArrayList<>(path));
			}
			return;
		}
		if(root.left != null){
			path.add(root.left.val);
			helper(root.left, path, res, cur+root.left.val, sum);
			path.remove(path.size() - 1);
		}
		if(root.right != null){
			path.add(root.right.val);
			helper(root.right, path, res, cur + root.right.val, sum);
			path.remove(path.size() - 1);
		}
	}
}
