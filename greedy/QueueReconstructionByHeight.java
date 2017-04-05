package greedy;
import java.util.*;
import java.util.Comparator;
/*
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), 
 * where h is the height of the person and k is the number of people 
 * in front of this person who have a height greater than or equal to h. 
 * Write an algorithm to reconstruct the queue.
 */

//pick up the tallest guy first
//when insert the next tall guy, just need to insert him into kth position
//repeat until all people are inserted into list
public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people){
		Arrays.sort(people, new Comparator<int[]>(){
			public int compare(int[] p1, int[] p2){
				//if(p1[0] == p2[0] -> compare the number in index 2. if small, in front
				//if(p1[0] != p2[0] -> compare the number in index 1. if large, in front
				return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
			}
		});
		List<int[]> res = new ArrayList<>();
		for(int[] cur : people){
			res.add(cur[1], cur);//res.add(cur[1] is the index to be inserted, cur)
			//if add number is the same, the later added one should be in the index, the previous one should be at its behind
		}
		return res.toArray(new int[0][0]);
	}
}
