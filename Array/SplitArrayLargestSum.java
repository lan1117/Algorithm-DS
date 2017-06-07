package Array;
import java.util.*;
/*
 * Given an array which consists of non-negative integers and an integer m, 
 * you can split the array into m non-empty continuous subarrays. 
 * Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
 */
/*
 * DP: dp[s+1,i] = min{ max(dp[s,j], n[i]+...+n[j-1]) }, i+1 <= j <= L-s
Binary Search:
The answer is between maximum value in input array numbers and sum of those numbers.
	Use binary search to approach the correct answer. 
	We have l = max number of array; r = sum of all numbers in the array;
	Every time we do mid = (l + r) / 2 and cut the result to half
1. See if we can use up all the elements in the array to form m subarray that 
subarray sum closet to target (upper limit)
2. We'll end up with two results: either we can divide the array into  m subarrays.
If we can't, it means that the mid value we pick is too small, 
because we've already tried our best to make sure each part holds as 
many non-negative numbers as we can but we still have numbers left. 
So, it is impossible to cut the array into m parts and make sure each parts is 
no larger than mid. We should increase m. This leads to l = mid + 1;
If we can, it is either we successfully divide the array into m parts and 
the sum of each part is less than mid, or we used up all numbers before we reach m. 
Both of them mean that we should lower mid because we need to find the minimum one. 
This leads to r = mid - 1;
 */
public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m){
		if(nums == null || nums.length == 0) return 0;
		//Sum is between [max, sum]
		long max = 0, sum = 0;
		for(int num : nums){
			max = Math.max(max, num);
			sum += num;
		}
		long l = max, r = sum; //Overflow
		while(l <= r){
			long mid = (l + r) / 2; //upper limit of the subarray sum
			if(valid(nums, m, mid)){
				r = mid - 1; //we can divide into m parts with sum smaller than target, target too large
			}
			else{
				//we cannot divide the whole array into m parts with sum smaller than target, target too small
				l = mid + 1;
			}
		}
		return (int)l;
	}
	public boolean valid(int[] num, int m, long target){
		int count = 1;
		long sum = 0;
		for(int n : num){
			sum += n;
			if(sum > target){
				sum = n;
				count++;
			}
			if(count > m){
				return false;
			}
		}
		return true;
	}
}
