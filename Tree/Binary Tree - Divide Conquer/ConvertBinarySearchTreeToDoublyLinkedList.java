package BinaryTreenDivideConquer;


public class ConvertBinarySearchTreeToDoublyLinkedList {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	public class DoublyListNode{
		int val;
		DoublyListNode next, prev;
		DoublyListNode(int val){
			this.val = val;
			this.next = this.prev = null;
		}
	}
	public class ResultType{
		DoublyListNode first, last;
		public ResultType(DoublyListNode first, DoublyListNode last){
			this.first = first;
			this.last = last;
		}
	}
	
	public DoublyListNode bstToDoublyList(TreeNode root){
		if(root == null){
			return null;
		}
		return helper(root).first;
	}
	private ResultType helper(TreeNode root){
		if(root == null){
			return null;
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		DoublyListNode node = new DoublyListNode(root.val);
		ResultType result = new ResultType(null, null);
		if(left == null){
			result.first = node;
		}
		else{
			result.first = left.first;
			left.last.next = node;
			node.prev = left.last;
		}
		
		if(right == null){
			result.last = node;
		}
		else{
			result.last = right.last;
			right.first.prev = node;
			node.next = right.first;
		}
		return result;
		
	}
}
