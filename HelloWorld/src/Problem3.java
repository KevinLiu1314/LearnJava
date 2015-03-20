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
		
public class Problem3 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long n = 600851475143L;
		long d, divisor_so_far = 0;
		
		d = 2;
   	    while (n > 1) {
	        divisor_so_far = d;
	    	while (n % d == 0) n /= d;
	    	d += 1;
   	    }
		System.out.println("Largest prime factor is:" + divisor_so_far);
   	    
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Finish in: " + diff);
	}
}
