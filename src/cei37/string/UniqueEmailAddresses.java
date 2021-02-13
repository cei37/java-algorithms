package cei37.string;

import java.util.HashSet;
import java.util.Set;

/*

929. Unique Email Addresses
Easy

1079

207

Add to List

Share
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 

 

Example 1:

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 

Note:

1 <= emails[i].length <= 100
1 <= emails.length <= 100
Each emails[i] contains exactly one '@' character.
All local and domain names are non-empty.
Local names do not start with a '+' character.

 */
public class UniqueEmailAddresses {

	public static void main(String[] args) {
		UniqueEmailAddresses uni = new UniqueEmailAddresses();
		
		String[] emails1 = {
			"test.email+alex@leetcode.com",
			"test.e.mail+bob.cathy@leetcode.com",
			"testemail+david@lee.tcode.com"
		};
		
		String[] emails2 = {
			"a@leetcode.com",
			"b@leetcode.com",
			"c@leetcode.com"
		};

		System.out.println(uni.numUniqueEmails(emails1));
	}

    public int numUniqueEmails(String[] emails) {
    	//let's validate edge cases
    	if (emails == null || emails.length == 0) return 0;
    	
    	Set<String> res = new HashSet<>();
    	
    	for (String email : emails) {
    		int at = email.indexOf('@');
    		String local = email.substring(0, at);
    		String domain = email.substring(at, email.length());
    		res.add(getRealLocalName(local) + domain);
    	}

    	return res.size();
    }

    private String getRealLocalName(String name) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i=0; i<name.length(); i++) {
    		if (name.charAt(i) == '+') {
    			break;
    		}

    		if (name.charAt(i) == '.') {
    			continue;
    		}

    		sb.append(name.charAt(i));
    	}
    	
    	return sb.toString();
    }
    
}