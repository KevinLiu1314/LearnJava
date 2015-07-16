/*# -*- coding: utf-8 -*-
# Problem 34
# Digit factorials

# 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

# Find the sum of all numbers which are equal to the sum of the factorial of
# their digits.

# Note: as 1! = 1 and 2! = 2 are not sums they are not included.

import math
from time import time

start_time = time()

d = {i: math.factorial(i) for i in range(10)}

l = []
n = 10
while n < 2000000:      # just guessing the UB
    digits = [int(x) for x in str(n)]
    sum_ = 0
    for digit in digits:
        sum_ += d[digit]

    if sum_ == n:
        l.append(n)

    n += 1

    # print n

    # if len(l) == 1: break

print l
print sum(l)

print "Total Time: ", time() - start_time

# Completed on Sat, 8 Mar 2014, 20:31
# Solve by: 46682
# ---------------
# [145, 40585]
# 40730
# Total Time:  12.4330000877
# [Finished in 12.6s]
*/

import java.util.*;

public class Problem34 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Map<Integer, Long> fs = new HashMap<Integer, Long>();
		for (int i=0; i<10; i++) fs.put(i,f(i));
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		int n = 10;
		while (n < 1000000) {
			int sum = 0;
			int i = n;
			while (i > 0) {
				sum += fs.get(i % 10);
				i /= 10;
			}
			if (sum == n) l.add(n);
			n++;
		}
		
		int sum = 0;
		for (int i=0; i < l.size(); i++) sum += l.get(i);
		System.out.println(sum);
		System.out.println(System.currentTimeMillis()-start);
	}

	public static long f(int n) {
		long result = 1;
		for (int i=n; i>0; i--) result *= i;
		return result;
	}
}

// Completed on Sun, 19 Apr 2015, 9:22PM
// 40730
// 278
