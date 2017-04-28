package graph;
import java.util.*;
/*
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, 
 * and k is a real number (floating point number). Given some queries, return the answers. 
 * If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 */
//image a / b = k as a link between node a and b, the weight from a to b is k, the reverse link is 1/k. 
//Query is to find a path between two nodes.
public class EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries){
		HashMap<String, ArrayList<String>> pairs = new HashMap<>();
		HashMap<String, ArrayList<Double>> valuesPairs = new HashMap<>();
		for(int i = 0; i < equations.length; i++){
			String[] equation = equations[i];
			if(!pairs.containsKey(equation[0])){
				pairs.put(equation[0], new ArrayList<String>());
				valuesPairs.put(equation[0], new ArrayList<Double>());
			}
			if(!pairs.containsKey(equation[1])){
				pairs.put(equation[1], new ArrayList<String>());
				valuesPairs.put(equation[1], new ArrayList<Double>());
			}
			pairs.get(equation[0]).add(equation[1]);
			pairs.get(equation[1]).add(equation[0]);
			valuesPairs.get(equation[0]).add(values[i]);
			valuesPairs.get(equation[1]).add(1/values[i]);
		}
		double[] res = new double[queries.length];
		for(int i = 0; i < queries.length; i++){
			String[] query = queries[i];
			res[i] = dfs(query[0], query[1], pairs, valuesPairs, new HashSet<String>(), 1.0);
			if(res[i] == 0.0) res[i] = -1;
		}
		return res;
	}
	private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> valuesPairs, HashSet<String> set, double value){
		if(set.contains(start)) return 0.0; //remove duplicate
		if(!pairs.containsKey(start)) return 0.0; //string without the equations
		if(start.equals(end)) return value; //base case
		set.add(start);
		
		ArrayList<String> strList = pairs.get(start);
		ArrayList<Double> valueList = valuesPairs.get(start);
		double tmp = 0.0;
		for(int i = 0; i < strList.size(); i++){
			tmp = dfs(strList.get(i), end, pairs, valuesPairs, set, value*valueList.get(i));
			if(tmp != 0.0){
				break;
			}
		}
		set.remove(start);
		return tmp;
	}
}
