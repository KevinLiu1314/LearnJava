//# Problem 4
//# Largest palindrome product
//
//# A palindromic number reads the same both ways. The largest palindrome made
//# from the product of two 2-digit numbers is 9009 = 91 X 99.
//
//# Find the largest palindrome made from the product of two 3-digit numbers.
//
//p = []
//for n1 in range(100, 1000):
//    for n2 in range(100, 1000):
//        product_str = str(n1 * n2)
//        if product_str == product_str[::-1]:
//            p.append(n1 * n2)
//
//print max(p)
//
//# Completed on Sat, 1 Mar 2014, 20:12
//# Solve by: 194397
//# ---------------
//# 906609
//# [Finished in 0.6s]

public class Problem4 {

	private static final int N = 10000;
	
	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		
		int[] p = new int[N];
		int n = 0;
		String productString = "";
		String reverseString = "";
		for (int n1 = 100; n1 < 1000; n1++) {
			for (int n2 = 100; n2 < 1000; n2++) {
				productString = Long.toString(n1 * n2);
				reverseString = new StringBuilder(productString).reverse().toString();
				if (productString.equals(reverseString)) {
					if (n == N) {
						System.out.println("Too many palindromes!");
						return;
					}
					p[n] = n1 * n2;
					n++;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i <= n; i++) {
			if (p[i] > max) max = p[i];
		}
		
		System.out.println(max);
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Finish in: " + diff);
	}

}
