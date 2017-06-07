package Array;

public class TrappingRainWater {
	public int trap(int[] height){
		if(height == null || height.length == 0) return 0;
		int l = 0, r = height.length - 1, vol = 0;
		int lHeight = height[l], rHeight = height[r];
		while(l < r){
			if(lHeight < rHeight){
				l++;
				if(lHeight > height[l]){
					vol += (lHeight - height[l]);//no need to update the value of lHeight
				}
				else{
					lHeight = height[l];
				}
			}
			else{
				r--;
				if(rHeight > height[r]){
					vol += (rHeight - height[r]);
				}
				else{
					rHeight = height[r];
				}
			}			
		}
		return vol;
	}
}
