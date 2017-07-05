package 二刷;
import java.util.*;
public class Oneeighteen_PascalTriangle {
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		for(int i = 0; i < numRows; i++){
			in.add(0, 1);
			for(int j = 1; j < in.size(); j++){
				in.set(j, in.get(j) + in.get(j + 1));
			}
			res.add(new ArrayList<>(in));
		}
		return res;
	}
}
