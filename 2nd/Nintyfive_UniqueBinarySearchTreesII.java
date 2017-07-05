package 二刷;
import java.util.*;

public class Nintyfive_UniqueBinarySearchTreesII {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	/*public List<TreeNode> generateTrees(int n){
		if(n == 0) return new ArrayList<>();
		List<TreeNode>[][] dp = new List[n+1][n+1];
		return generateNode(dp, 1, n);
	}
	public List<TreeNode> generateNode(List<TreeNode>[][] dp, int start, int end){
		List<TreeNode> list = new ArrayList<>();
		if(start > end){
			list.add(null);
			return list;
		}
		if(dp[start][end] != null){
			return dp[start][end];
		}
		for(int i = start; i <= end; i++){
			List<TreeNode> left = generateNode(dp, start, i-1);
			List<TreeNode> right = generateNode(dp, i+1, end);
			for(TreeNode l : left){
				for(TreeNode r : right){
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					list.add(root);
				}
			}
		}
		dp[start][end] = list;
		return list;*/
	public List<TreeNode> generateTrees(int n){
		return generate(1, n);
	}
	public List<TreeNode> generate(int start, int end){
		List<TreeNode> list = new ArrayList<>();
		if(start > end){
			list.add(null);
			return list;
		}
		if(start == end){
			list.add(new TreeNode(start));
			return list;
		}
		List<TreeNode> left, right;
		for(int i = start; i <= end; i++){
			left = generate(start, i-1);
			right = generate(i + 1, end);
			for(TreeNode l : left){
				for(TreeNode r : right){
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					list.add(root);
				}
			}
		}
		return list;
	}
}
