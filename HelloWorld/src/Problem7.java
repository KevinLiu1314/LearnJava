//# Problem 7
//# 10001st prime
//
//# By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
//# we can see that the 6th prime is 13.
//
//# What is the 10 001st prime number?
//
//import math
//
//
//def prime():
//    n = 2
//    yield n
//    
//    while True:
//        n += 1
//        d = 2
//        is_prime = False
//        while n % d != 0:
//            d += 1
//            if d > math.sqrt(n):
//                is_prime = True
//                break
//
//        if is_prime:
//            yield n
//
//p = prime()
//
//for i in range(10001):
//    y = next(p)
//
//print y
//
//# Completed on Sat, 1 Mar 2014, 23:14
//# Solve by: 179409
//# ---------------
//# 104743
//# [Finished in 1.1s]

public class Problem7 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		long n = 2;
		int ith = 100001;
		int i = 1;

		while (true) {
			n += 1;
			int d = 2;
			boolean isPrime = false;
			while (n % d != 0) {
				d += 1;
				if (d > Math.sqrt(n)) {
					isPrime = true;
					break;
				}
			}
			if (isPrime) {
				i += 1;
				if (i == ith) {
					System.out.println(n);
					break;
				}
			}
		}
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Finish in: " + diff);
	}
}
