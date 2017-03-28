package BinaryTreenDivideConquer;
//Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

public class Subtree_With_Maximum_Average {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	public class ResultType{
		public int sum;
		public int num;
		public ResultType(int sum, int num){
			this.sum = sum;
			this.num = num;
		}
	}
	
	private ResultType subtreeResult = null;
	private TreeNode subtree = null;
	public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        helper(root);
        return subtree;
        
    }
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, 0);
        }
        //divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //conquer
        ResultType result = new ResultType(left.sum + right.sum + root.val, left.num + right.num + 1);
        
        if(subtree == null || subtreeResult.sum * result.num < result.sum * subtreeResult.num){
            subtreeResult = result;
            subtree = root;
        }
        return result;
    }
}
