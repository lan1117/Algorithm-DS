package 二刷;
//import java.util.*;
public class Onesixtyfive_CompareVersionNumbers {
	public int compareVersion(String version1, String version2){
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int len1 = v1.length, len2 = v2.length;
		for(int i = 0; i < Math.max(len1, len2); i++){
			int num1 = i < len1 ? Integer.parseInt(v1[i]) : 0;
			int num2 = i < len2 ? Integer.parseInt(v2[i]) : 0;
			if(num1 > num2) return 1;
			if(num2 > num1) return -1;
		}
		return 0;
	}
}
