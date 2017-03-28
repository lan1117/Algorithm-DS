package BinaryTreenDivideConquer;
import java.util.*;

class TreeNode{
	public int val;
	public TreeNode left, right;
	public TreeNode(int val){
		this.val = val;
		this.left = this.right = null;
	}
}

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root){
		List<String> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		
		helper(root, String.valueOf(root.val), res);
		return res;
	}
	private void helper(TreeNode root, String path, List<String> res){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			res.add(path);
			return;
		}
		if(root.left != null){
			helper(root.left, path + "->" + String.valueOf(root.left.val), res);
		}
		if(root.right != null){
			helper(root.right, path + "->" + String.valueOf(root.right.val), res);
		}
	}
}
