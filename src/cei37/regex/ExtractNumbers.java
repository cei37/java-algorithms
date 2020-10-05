package cei37.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumbers {

	public static void main(String[] args) {
		String str = "Role Change Event 1 - Process Identities ss 3 to 338";

        //Matcher m = Pattern.compile("\\d+ to \\d+").matcher(str);
		
		//Matcher m = Pattern.compile("(?<= )([0-9]+)(?= to [0-9]+)").matcher(str);
		Matcher m = Pattern.compile("(?<= )([0-9]+)(?= to [0-9]+)").matcher(str);
		//"numFound=\"([0-9]+)\""

        //String n = m.find() ? m.group() : "";
        
        while (m.find()) {
            System.out.println(m.group());
        }
	}
}
