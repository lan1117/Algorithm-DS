package BinaryTreenDivideConquer;


//same as lowest common ancestor except that the node A, B may not include in the binary tree.
public class LowestCommonAncestorIII {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	private class ResultType{
		public boolean a_exist;
		public boolean b_exist;
		public TreeNode node;
		ResultType(boolean a, boolean b, TreeNode n){
			a_exist = a;
			b_exist = b;
			node = n;
		}
	}
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B){
		if(root == null){
			return null;
		}
		ResultType rt = helper(root, A, B);
		if(rt.a_exist && rt.b_exist){
			return rt.node;
		}
		else{
			return null;
		}
	}
	private ResultType helper(TreeNode root, TreeNode A, TreeNode B){
		if(root == null){
			return new ResultType(false, false, null);
		}
		ResultType left = helper(root.left, A, B);
		ResultType right = helper(root.right, A, B);
		
		boolean a_ex = left.a_exist || right.a_exist || root == A;
		boolean b_ex = left.b_exist || right.b_exist || root == B;
		
		if(root == A || root == B){
			return new ResultType(a_ex, b_ex, root);
		}
		if(left.node != null && right.node != null){
			return new ResultType(a_ex, b_ex, root);
		}
		if(left.node!= null){
			return new ResultType(a_ex, b_ex, left.node);
		}
		if(right.node != null){
			return new ResultType(a_ex, b_ex, right.node);
		}
		return new ResultType(a_ex, b_ex, null);
	}
}
