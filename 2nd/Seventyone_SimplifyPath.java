package 二刷;
import java.util.*;

public class Seventyone_SimplifyPath {
	public String simplifyPath(String path){
		Stack<String> stack = new Stack<String>();
		Set<String> skip = new HashSet<String>(Arrays.asList("", ".", ",", ".."));
		for(String dir : path.split("/")){
			if(dir.equals("..") && !stack.isEmpty()) stack.pop();
			else if(!skip.contains(dir)) stack.push(dir);
		}
		String str = "";
		for(String s : stack) str = str + "/" + s;
		return str.length() == 0 ? "/" : str;
	}
}
