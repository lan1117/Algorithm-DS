package 二刷;

import 二刷.Eightysix_PartitionList.ListNode;

public class Onefourtythree_ReorderList {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	public void reorderList(ListNode head){
		if(head == null || head.next == null) return;
		//find the middle of the list, slow should be at the upper half when even nodes
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		
		//reverse the half after middle
		ListNode pre = slow;
		ListNode cur = slow.next;
		while(cur.next != null){
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = pre.next;
			pre.next = tmp;
		}
		
		//start reorder one by one
		ListNode p1 = head, p2 = pre.next;
		while(p1 != pre){
			pre.next = p2.next;
			p2.next = p1.next;
			p1.next = p2;
			p1 = p2.next;
			p2 = pre.next;
		}
	}
}
