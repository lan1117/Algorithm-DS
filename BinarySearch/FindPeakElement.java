package BinarySearch;

//given [1, 2, 1, 3, 4, 5, 7, 6]
//return index 1 or 6
public class FindPeakElement {
	public int findPeak(int[] A){
		int start = 1; 
		int end = A.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(A[mid] < A[mid - 1]){
				end = mid;
			}
			if(A[mid] < A[mid + 1]){
				start = mid;
			}
			else{
				end = mid;
			}
		}
		if(A[start] > A[end]){
			return start;
		}
		else{
			return end;
		}
	}
}
