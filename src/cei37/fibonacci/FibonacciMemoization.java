package cei37.fibonacci;


/*
 * In computing, memoization or memoisation is an optimization technique 
 * used primarily to speed up computer programs by storing the results of 
 * expensive function calls and returning the cached result when the same inputs occur again.
 */
public class FibonacciMemoization {

	public static void main(String[] args) {
		FibonacciMemoization fr = new FibonacciMemoization();
		
		System.out.println(fr.fibonacci(5));

	}
	
	public int fibonacci( int n) {
		return fibonacci(n, new int[n + 1]);
	}
	
	public int fibonacci( int i, int[] memo) {
		if (i == 1) return 1;
		if (i == 2) return 2;
		
		if (memo[i] == 0) {
			memo[i] = fibonacci(i - 1) + fibonacci(i - 2);
		}
		
		return memo[i];
	}
}
