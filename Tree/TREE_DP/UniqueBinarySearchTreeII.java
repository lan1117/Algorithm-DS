package Tree_DP;
import java.util.*;

public class UniqueBinarySearchTreeII {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public List<TreeNode> generateTrees(int n){
		if(n == 0){
			return new ArrayList<TreeNode>();
		}
		List<TreeNode>[][] dp = new List[n + 1][n + 1];
		return generateNode(dp, 1, n);
	}
	private List<TreeNode> generateNode(List<TreeNode>[][] dp, int start, int end){
		List<TreeNode> list = new ArrayList<>();
		if(start > end){
			list.add(null);
			return list;
		}
		if(dp[start][end] != null){
			return dp[start][end];
		}
		for(int i = start; i <= end; i ++){
			List<TreeNode> left = generateNode(dp, start, i - 1);
			List<TreeNode> right = generateNode(dp, i + 1, end);
			for(TreeNode l: left){
				for(TreeNode r : right){
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					list.add(root);
				}			
			}
		}
		dp[start][end] = list;
		return list;
	}
}
