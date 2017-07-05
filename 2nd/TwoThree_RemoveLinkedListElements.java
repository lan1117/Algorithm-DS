package 二刷;

public class TwoThree_RemoveLinkedListElements {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int val){this.val = val;}
	}
	public ListNode removeNode(ListNode node, int val){
		if(node == null) return null;
		ListNode dummy = new ListNode(-1);
		ListNode cur = node;
		ListNode pre = dummy;
		dummy.next = node;
		while(cur != null){
			if(cur.val == val){
				pre.next = cur.next;
				cur = cur.next;
			}else{
				cur = cur.next;
				pre = pre.next;
			}
		}
		return dummy.next;
	}
}
