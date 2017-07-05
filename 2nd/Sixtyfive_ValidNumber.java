package 二刷;

public class Sixtyfive_ValidNumber {
	//e and . cannot show in 2 times
	//+ or - should show in the first place or should behind e
	//. cannot be behind e
	//there should be num behind and before e
	
	public boolean isNumber(String s){
		s = s.trim();
		boolean dot = false; //has dot appeared in the string
		boolean e = false;
		boolean num = false;
		boolean nume = true; //number after e
		for(int i = 0; i < s.length(); i++){
			char d = s.charAt(i);
			if(d >= '0' && d <= '9'){
				num = true;
				nume = true;
			}
			else if(d == '.'){
				if(dot || e){
					return false;
				}
				dot = true;
			}
			else if(d == 'e'){
				if(e || !num){
					return false;
				}
				e = true;
				nume = false;
			}
			else if(d == '+' || d == '-'){
				if(i != 0 && s.charAt(i - 1) != 'e'){
					return false;
					}
			}
			else{
				return false;
			}
		}
		return num && nume;
	}
}
