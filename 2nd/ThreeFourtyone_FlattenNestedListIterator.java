package 二刷;
import java.util.*;
//boolean isInteger();
//Integer getInteger();
//public List<NestedInteger> getList();
public class ThreeFourtyone_FlattenNestedListIterator implements Iterator<Integer>{
	//private Iterator<List<NestedInteger>> i;
	Stack<NestedInteger> stack;
	//O(N)
	public ThreeFourtyone_FlattenNestedListIterator(List<NestedInteger> nestedList){
		stack = new Stack<>();
		for(int i = nestedList.size() - 1; i >= 0; i--){
			stack.push(nestedList.get(i));
		}
	}
	//Average O(1) time <= O(N)/N
	@Override
	public Integer next(){
		if(hasNext()){
			return stack.pop().getInteger();
		}
		return null;
	}
	//Worst case O(N) => average O(n) / n = O(1) time
	@Override
	public boolean hasNext(){
		//check for next integer and flatten the list among the way
		while(!stack.isEmpty()){
			NestedInteger cur = stack.peek();
			if(cur.isInteger()) return true;
			
			stack.pop();
			for(int i = cur.getList().size() - 1; i >= 0 ; i--){
				stack.push(cur.getList().get(i));
			}
		}
		return false; //return flase when stack is empty
	}
}
