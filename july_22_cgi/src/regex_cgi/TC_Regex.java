package regex_cgi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TC_Regex {
	
	public static void main(String[] args) {
		
		Pattern pattern=Pattern.compile("\\d");
		System.out.println(Pattern.matches("abc", "abc"));
		Matcher matcher=pattern.matcher("123");
		System.out.println(matcher.find());
		//^a f$ 
	}
}
