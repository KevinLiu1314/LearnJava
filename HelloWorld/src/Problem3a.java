//# Problem 3
//# Largest prime factor
//
//# The prime factors of 13195 are 5, 7, 13 and 29.
//
//# What is the largest prime factor of the number 600851475143?
//
//# Completed on Sat, 1 Mar 2014, 19:47
//# Solve by: 213234
//# ---------------
//# 6857
		
public class Problem3a {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long n = 600851475143L;
		
		System.out.println("Largest prime factor is: " + lpf(n));
   	    
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Finish in: " + diff);
	}

	private static long lpf(long n) {
		long d, divisor_so_far = 1;
		
		if (n == 2) return 2;
		
		d = 2;
   	    while (n > 1) {
	        divisor_so_far = d;
	    	while (n % d == 0) n /= d;
	    	d += 1;
   	    }
		return divisor_so_far;
	}
}
