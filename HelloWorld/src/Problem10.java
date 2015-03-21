//# Problem 10
//# Summation of primes
//
//# The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
//# Find the sum of all the primes below two million.
//
//import math
//
//
//def primes():
//    n = 2
//    yield n
//
//    n = 3
//    yield n
//
//    primes_so_far = [2, 3]      # takes care of index out of range case
//                                # when n = 3 if initial is only [2]
//
//    while True:
//        n += 1
//        divisor_index = 0
//        is_prime = False
//        while n % primes_so_far[divisor_index] != 0:
//            divisor_index += 1
//            if primes_so_far[divisor_index] > math.sqrt(n):
//                is_prime = True
//                break
//
//        if is_prime:
//            yield n
//            primes_so_far.append(n)
//
//p = primes()
//
//sum = 0
//next_p = next(p)
//while next_p < 2000000:
//    sum += next_p
//    next_p = next(p)
//
//print sum
//
//# Completed on Sun, 2 Mar 2014, 00:00
//# Solve by: 144048
//# ---------------
//# 142913828922
//# [Finished in 14.2s]

import java.util.*; 

public class Problem10 {

	public static void main(String[] args) {
		ArrayList<Long> primesSoFar = new ArrayList<Long>();
		primesSoFar.add(2L);
		primesSoFar.add(3L);
		
		long sum = 2 + 3;
		
		long n = 3;
		while (true) {
			n++;
			int divisorIndex = 0;
			boolean isPrime = false;
			while (n % primesSoFar.get(divisorIndex) != 0) {
				divisorIndex++;
				if (primesSoFar.get(divisorIndex) > Math.sqrt(n)) {
					isPrime = true;
					break;
				}
			}
			if (isPrime) {
				if (n > 2000000)
					break;
				sum += n;
				primesSoFar.add(n);
			}
		}
		System.out.println(sum);
//		for (int i = 0; i < 10; i++)
//			System.out.print(primesSoFar.get(i) + " ");
	}
}

//while n % primes_so_far[divisor_index] != 0:
//divisor_index += 1
//if primes_so_far[divisor_index] > math.sqrt(n):
//  is_prime = True
//  break
//
//if is_prime:
//yield n
//primes_so_far.append(n)
//
