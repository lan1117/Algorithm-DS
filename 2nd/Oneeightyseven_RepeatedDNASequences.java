package 二刷;
import java.util.*;

public class Oneeightyseven_RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s){
		Set<String> seen = new HashSet<>();
		Set<String> dna = new HashSet<>();
		for(int i = 0; i + 9 < s.length(); i++){
			String sub = s.substring(i, i+10);
			if(!seen.add(sub)) dna.add(sub);
		}
		return new LinkedList(dna);
	}
}
