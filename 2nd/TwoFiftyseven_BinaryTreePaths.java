package 二刷;
import java.util.*;
public class TwoFiftyseven_BinaryTreePaths {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public List<String> binaryTreePaths(TreeNode root){
		List<String> res = new ArrayList<>();
		if(root == null) return res;
		backtrack(root, res, "");
		return res;
	}
	public void backtrack(TreeNode root, List<String> res, String str){
		if(root.left == null && root.right == null){
			str = str + root.val;
			res.add(str);
			return;
		}
		if(root.left != null){
			backtrack(root.left, res, str + root.val + "->");
		}
		if(root.right != null){
			backtrack(root.right, res, str + root.val + "->");
		}
	}
}
