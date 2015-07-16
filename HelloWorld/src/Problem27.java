/*# -*- coding: utf-8 -*-
# Problem 27
# Quadratic primes

# Euler discovered the remarkable quadratic formula:

# n² + n + 41

# It turns out that the formula will produce 40 primes for the consecutive
# values n = 0 to 39. However, when n = 40, 40^2 + 40 + 41 = 40(40 + 1) + 41 is
# divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
# divisible
# by 41.

# The incredible formula  n² − 79n + 1601 was discovered, which produces 80
# primes for the consecutive values n = 0 to 79. The product of the
# coefficients, −79 and 1601, is −126479.

# Considering quadratics of the form:

#     n² + an + b, where |a| < 1000 and |b| < 1000

#     where |n| is the modulus/absolute value of n
#     e.g. |11| = 11 and |−4| = 4

# Find the product of the coefficients, a and b, for the quadratic expression
# that produces the maximum number of primes for consecutive values of n,
# starting with n = 0.

from UsefulFunctions import is_prime
from time import time


def f(n, a, b):
    return n * (n + a) + b

start_time = time()
d = {}

for a in range(-999, 1000):
    for b in range(-999, 1000):
        n = 0
        while is_prime(f(n, a, b)):
            n += 1
        d[(a, b)] = n

m = max(d.values())

for a, b in d:
    if d[(a, b)] == m:
        print "a=%d, b=%d, a*b=%d -> %d" % (a, b, a * b, m)

print "Total Time: ", time() - start_time

# Completed on Tue, 4 Mar 2014, 04:52
# Solve by: 41748
# ---------------
# a=-61, b=971, a*b=-59231 -> 71
# Total Time:  27.5460000038
# [Finished in 31.6s]
*/

public class Problem27 {

	public static void main(String[] args) {
		int max_n = 0, saved_a = 0, saved_b = 0;
		
		long start = System.currentTimeMillis();
		
		for (int a=-999; a<1000; a++) {
			for (int b=-999; b<1000; b++) {
				int n = 0;
				while (isPrime(n*(n+a)+b)) n++;
				if (n>max_n) {
					max_n = n;
					saved_a = a;
					saved_b = b;
				}
			}
		}
		
		System.out.format("a=%d, b=%d, a*b=%d -> %d\n", saved_a, saved_b, saved_a*saved_b, max_n);
		System.out.println(System.currentTimeMillis()-start);
	}

	public static boolean isPrime(int n) {
		if (n<2) return false;
		
		int d = 2;
		while (d*d <= n) {
			if (n%d == 0) return false;
			d++;
		}
		return true;
	}
}

// Completed on Sun, 18 Apr 2015, 04:00PM
// a=-61, b=971, a*b=-59231 -> 71
// 342
