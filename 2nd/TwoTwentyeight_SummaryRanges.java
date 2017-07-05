package 二刷;
import java.util.*;
public class TwoTwentyeight_SummaryRanges {
	public List<String> summaryRanges(int[] nums){
		/*List<String> res = new ArrayList<>();
		if(nums == null || nums.length == 0) return res;
		int start = nums[0], end = nums[0];
		if(nums.length == 1){
			res.add(start + "");
			return res;
		}
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == nums[i-1] + 1){
				if(i == nums.length - 1){
					end = nums[i];
					res.add(getString(start, end));
					return res;
				}
				end = nums[i];
			}else{
				end = nums[i-1];
				res.add(getString(start, end));
				start = nums[i];
				if(i == nums.length - 1){
					res.add(nums[i] + "");
					return res;
				}
			}
		}
		return res;
	}
	public String getString(int start, int end){
		if(start == end){
			return start + "";
		}
		return start + "->" + end;*/
		List<String> list = new LinkedList<>();
        if(nums == null){
            return list;
        }
        for(int i=0; i<nums.length; i++){
            String start = String.valueOf(nums[i]);
            while(i+1<nums.length && nums[i+1] == nums[i]+1){
                //If the next number is continuous, then continue check for next integer
                i++;
            }
            String end = String.valueOf(nums[i]);
            //If start == end add one number
            if(end.equals(start))
                list.add(end);
            else
                list.add(start + "->" + end);
        }
        return list;
	}
}
