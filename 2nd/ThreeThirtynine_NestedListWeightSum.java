package 二刷;
import java.util.*;
//boolean isInteger();
//Integer getInteger();
//List<NestedInteger> getList();	
public class ThreeThirtynine_NestedListWeightSum {
	
	public int depthSum(List<NestedInteger> nestedList){
		return helper(nestedList, 1);
	}
	public int helper(List<NestedInteger> nestedList, int depth){
		int res = 0;
		for(NestedInteger n : nestedList){
			if(n.isInteger()){
				res += depth * n.getInteger();
			}else{
				res += helper(n.getList(), depth+1);
			}
		}
		return res;
	}
}
