package cei37.hash;

//Java program to generate short url from integer id and 
//integer id back from short url. 
import java.util.*;
import java.lang.*;
import java.io.*;

public class Base62 {

	// Function to generate a short url from integer ID
	static String idToShortURL(long n) {
		// Map to store 62 possible characters
		char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		//char map1[] = new char[2147483647];

		StringBuffer shorturl = new StringBuffer();

		// Convert given integer id to a base 62 number
		while (n > 0) {
			// use above map to store actual character
			// in short url
			shorturl.append(map[(int)(n % 62L)]);
			n = n / 62L;
		}

		// Reverse shortURL to complete base conversion
		return shorturl.reverse().toString();
	}

	// Function to get integer ID back from a short url
	static long shortURLtoID(String shortURL) {
		long id = 0L; // initialize result

		// A simple base conversion logic
		for (int i = 0; i < shortURL.length(); i++) {
			if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
				id = id * 62 + shortURL.charAt(i) - 'a';
			if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z')
				id = id * 62 + shortURL.charAt(i) - 'A' + 26;
			if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
				id = id * 62 + shortURL.charAt(i) - '0' + 52;
		}
		return id;
	}

	// Driver Code
	public static void main(String[] args) throws IOException {
		//for (int i=1000000; i<10000000; i++) {
			//long n = 922337203685L;
			//long n = 122337203685L;
			//long n =  100000000000L;
			long n = 2999999999999L;
			String shorturl = idToShortURL(n);
			System.out.println("Shorturl: " + shorturl + " Id: " + shortURLtoID(shorturl));
		//}
	}

}