package 二刷;
import java.util.*;
public class TwoNintyseven_SerializeAndDeserializeBT {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	//因为要链接root的左边和右边 所以要用preorder存，这样才能直接root.left和root.right了
	
	public String serialize(TreeNode root){
		StringBuilder sb = new StringBuilder();
		serialz(root, sb);
		return sb.toString();
		
	}
	public void serialz(TreeNode root, StringBuilder sb){
		if(root == null){
			sb.append("#,");
			return;
		}
		sb.append(root.val + ",");
		serialz(root.left, sb);
		serialz(root.right, sb);
	}
	public TreeNode deserialize(String s){
		String[] tree = s.split(",");
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(tree));
		return build(queue);
	}
	public TreeNode build(Queue<String> queue){
		String val = queue.poll();
		if(val.equals("#")){
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = build(queue);
		node.right = build(queue);
		return node;
	}
}
