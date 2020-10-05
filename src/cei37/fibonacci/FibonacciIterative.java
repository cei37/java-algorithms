package cei37.fibonacci;

public class FibonacciIterative {

	/*
	 * n:1
	 * 
	 */
	
	public static void main(String[] args) {
		FibonacciIterative fi = new FibonacciIterative();
		System.out.println(fi.fibonacci(40));
	}

	public int fibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		int a = 0;
		int b = 1;
		
		for (int i = 1; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		
		return a + b;
	}
}
