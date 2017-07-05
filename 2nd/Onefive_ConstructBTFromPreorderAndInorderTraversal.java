package 二刷;
import java.util.*;
public class Onefive_ConstructBTFromPreorderAndInorderTraversal {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	//inorder: 	4, 2, 5, 1, 6, 3, 7
	//preorder:	1, 2, 4, 5, 3, 6, 7
	int preIndex = 0;
	public TreeNode buildTree(int[] preorder, int[] inorder){
		if(preorder == null || preorder.length == 0) return null;
		return Construct(inorder, preorder, 0, inorder.length -1);
	}
	public TreeNode Construct(int[] inorder, int[] preorder, int start, int end){
		if(start > end) return null;
		TreeNode node = new TreeNode(preorder[preIndex++]);
		if(start == end) return node;
		
		int inIndex = search(node, start, end, inorder);
		
		node.left = Construct(inorder, preorder, start, inIndex-1);
		node.right = Construct(inorder, preorder, inIndex+1, end);
		return node;
	}
	public int search(TreeNode node, int start, int end, int[] inorder){
		for(int i = start; i <= end; i++){
			if(inorder[i] == node.val){
				return i;
			}
		}
		return -1;
	}
}
