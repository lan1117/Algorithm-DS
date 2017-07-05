package 二刷;
import java.util.*;
public class Onesixtysix_FractionToRecurringDecimal {
	public String factionToDecimal(int numerator, int denominator){
		StringBuilder sb = new StringBuilder();
		if(numerator == 0) return "0";
		sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
		//to prevent overflow
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		
		//integral part
		sb.append(num / den);
		num %= den;
		if(num == 0){
			return sb.toString();
		}
		
		//fractional part
		sb.append(".");
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(num, sb.length());
		while(num != 0){
			num *= 10;
			sb.append(num / den);
			num %= den;
			if(map.containsKey(num)){
				int index = map.get(num);
				sb.insert(index, "(");
				sb.append(")");
				break;
			}
			else{
				map.put(num, sb.length());
			}
		}
		return sb.toString();
	}
}
