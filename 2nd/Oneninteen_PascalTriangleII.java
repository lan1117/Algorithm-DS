package 二刷;
import java.util.*;

public class Oneninteen_PascalTriangleII {
	public List<Integer> getRow(int rowIndex){
		List<Integer> res = new ArrayList<>();
		int newRow = rowIndex + 1;
		for(int i = 0; i < newRow; i++){
			res.add(0,  1);
			for(int j = 1; j < res.size() - 1; j++){
				res.set(j, res.get(j) + res.get(j + 1));
			}
		}
		return res;
	}
}
