package cei37.dailyCode;

import java.util.*;
/**
 * 
721. Accounts Merge

Given a list accounts, each element accounts[i] is a list of strings, 
where the first element accounts[i][0] is a name, and the rest of the 
elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely 
belong to the same person if there is some email that is common to 
both accounts. Note that even if two accounts have the same name, 
they may belong to different people as people could have the same 
name. A person can have any number of accounts initially, but all 
of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following 
format: the first element of each account is the name, and the rest 
of the elements are emails in sorted order. The accounts themselves 
can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], 
["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 */
public class AccountsMerge {

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		

		List<String> a1 = new ArrayList<String>();
		a1.add("John");
		a1.add("johnsmith@mail.com");
		a1.add("john00@mail.com");
		accounts.add(a1);
		
		a1 = new ArrayList<String>();
		a1.add("John");
		a1.add("johnnybravo@mail.com");
		accounts.add(a1);
		
		a1 = new ArrayList<String>();
		a1.add("John");
		a1.add("johnsmith@mail.com");
		a1.add("john_newyork@mail.com");
		accounts.add(a1);
		
		a1 = new ArrayList<String>();
		a1.add("Mary");
		a1.add("mary@mail.com");
		accounts.add(a1);
		//#####################
		
		/*List<String> a2 = new ArrayList<String>();
		a2.add("Alex");
		a2.add("Alex5@m.co");
		a2.add("Alex4@m.co");
		a2.add("Alex0@m.co");
		accounts.add(a2);
		
		a2 = new ArrayList<String>();
		a2.add("Ethan");
		a2.add("Ethan3@m.co");
		a2.add("Ethan3@m.co");
		a2.add("Ethan0@m.co");
		accounts.add(a2);
		
		a2 = new ArrayList<String>();
		a2.add("Kevin");
		a2.add("Kevin4@m.co");
		a2.add("Kevin2@m.co");
		a2.add("Kevin2@m.co");
		accounts.add(a2);
		
		a2 = new ArrayList<String>();
		a2.add("Gabe");
		a2.add("Gabe0@m.co");
		a2.add("Gabe3@m.co");
		a2.add("Gabe2@m.co");
		accounts.add(a2);
		
		a2 = new ArrayList<String>();
		a2.add("Gabe");
		a2.add("Gabe3@m.co");
		a2.add("Gabe4@m.co");
		a2.add("Gabe2@m.co");
		accounts.add(a2);*/
		
		AccountsMerge a = new AccountsMerge();
		System.out.println(a.accountsMerge(accounts));
	}

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    	
        return null;
    }
}
