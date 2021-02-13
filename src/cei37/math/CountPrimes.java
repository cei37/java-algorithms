package cei37.math;

import java.util.Arrays;

/*
204. Count Primes
Easy

2688

718

Add to List

Share
Count the number of prime numbers less than a non-negative number, n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 */
public class CountPrimes {

	public static void main(String[] args) {
		CountPrimes co = new CountPrimes();
		System.out.println(co.countPrimes(10));
	}

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }

    public int countPrimes_2(int n) {
        if(n < 2) return 0;
        
        boolean[] primes = new boolean[n];
        
        for(int i = 2; i * i < n; i++) {
            if(!primes[i]) {
                for(int j = i * i; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }
        
        int count = 0;
        for(int i = 2; i < primes.length; i++) {
            if(!primes[i]) count++;
        }
        
        return count;
    }

    //Time Limit Exceeded
    public int countPrimes_1(int n) {
    	if (n == 0 || n == 1) return 0;
    	
    	int count = 0;
    	boolean[] sieve = new boolean[n + 1];

    	int i=2; //current
    	int j=3; //extra iteration
    	
    	while(i < n) {
    		if (!sieve[i]) {
    			//this is a prime
    			count++;
    			while(j<=n) {
    				if (!sieve[j]) {
    					sieve[j] = j % i == 0;
    				}
    				j++;
    			}
    		}
    		i++;
    		j = i + 1;
    	}

    	return count;
    }
}