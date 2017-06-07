package backtracking;

public class ConstructTreeFromInorderAndPreorder {
	class Node{
		char data;
		Node left, right;
		public Node(char data){
			this.data = data;
			left = right = null;
		}
	}
	Node root;
	int preIndex = 0;
	public Node construct(char in[], char pre[], int instart, int inend){
		if(instart > inend) return null;
		Node tNode = new Node(pre[preIndex++]);
		if(instart == inend){
			return tNode;
		}
		int inIndex = search(in, instart, inend, tNode.data);
		tNode.left = construct(in, pre, instart, inIndex - 1);
		tNode.right = construct(in, pre, inIndex + 1, inend);
		
		return tNode;
	}
	int search(char arr[], int start, int end, char value){
		for(int i = start; i <= end; i++){
			if(arr[i] == value){
				return i;
			}
		}
		return -1;
	}
	
}
