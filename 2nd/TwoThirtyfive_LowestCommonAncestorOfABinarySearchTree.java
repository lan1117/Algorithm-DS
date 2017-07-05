package 二刷;

public class TwoThirtyfive_LowestCommonAncestorOfABinarySearchTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || p == null || q == null) return null;
		TreeNode ancestor = root;
		while(true){
			if(q.val < ancestor.val && p.val < ancestor.val){
				ancestor = ancestor.left;
			}
			else if(q.val > ancestor.val && p.val > ancestor.val){
				ancestor = ancestor.right;
			}
			else{
				break;
			}
		}
		return ancestor;
	}
}
