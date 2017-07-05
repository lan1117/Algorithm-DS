package 二刷;

public class ThreeSixtyfive_WaterAndJugProblem {
	public boolean canMeasureWater(int x, int y, int z){
		if(x+y < z) return false;
		if(x == z || y == z || x + y == z) return true;
		return z % helper(x, y) == 0;
	}
	public int helper(int a, int b){
		while(b != 0){
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}
}
