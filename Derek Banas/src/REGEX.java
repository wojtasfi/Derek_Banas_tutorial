
import java.util.regex.*;

public class REGEX {

	public static void main(String[] args) {


		String longString = " Derek Banas CA 12345 (412)555-1212 johnsmith@hotmail.com 412 -555-1234";
		String strangeString = " 1Z aaa **** *** {{{ {{ { ";
		
		//Word  that is 2 to 20 character
		
		//[A-Za-z]{2,20} \\w{2,20}
		
		
		/*
		[A-Za]
		[A-Z] A do Z
		[Za] - male i duze litery
		[^] nie poasiadja
		\\s  white sace
		
		{n,m} n-min m-max
		
		\\d
		\\D -digits
		
		w wrod type character
		w[A-Za-z0-9_]
		
		
		
		*/
		
		
		//regexChecker("\\s[A-Za-z]{2,20}\\s", longString);
		
		//zip code is 5 dig long
		//regexChecker("\\s\\d{5}\\s", longString);
		
		//{n,} only minimum
		// + whatever is next must occur at lest once
		// . ^ * + ? {} [] \ | () always need to be backslashed
		
		
		
		
		regexChecker("[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[A-Za-z]{2,4}", strangeString);
		
	}
	
	public static void regexChecker(String theRegex, String str2check){
		
		Pattern checkRegex = Pattern.compile(theRegex);
		
		Matcher regexMatcher = checkRegex.matcher(str2check);
		
		while(regexMatcher.find()){
			if(regexMatcher.group().length() != 0){
				System.out.println(regexMatcher.group().trim());
			}
			
			System.out.println(regexMatcher.start());
			System.out.println(regexMatcher.end());
		}
		
	}

}
