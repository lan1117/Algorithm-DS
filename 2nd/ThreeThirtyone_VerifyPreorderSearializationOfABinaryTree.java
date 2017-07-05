package 二刷;

public class ThreeThirtyone_VerifyPreorderSearializationOfABinaryTree {
	public boolean isValidSearialization(String preorder){
		String[] str = preorder.split(",");
		int diff = 1;
		for(String node : str){
			if(--diff < 0) return false;
			if(!node.equals("#")) diff += 2;
		}
		return diff == 0;
	}
}
