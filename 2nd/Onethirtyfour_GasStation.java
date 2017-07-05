package 二刷;

public class Onethirtyfour_GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost){
		int total = 0, tank = 0, start = 0;
		for(int i = 0; i < gas.length; i++){
			int fuel = gas[i] - cost[i];
			tank += fuel;
			total += fuel;
			if(tank < 0){
				tank = 0;
				start = i+1;
			}
		}
		return total < 0 ? -1 : start;
	}
}
