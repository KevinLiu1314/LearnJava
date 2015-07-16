/*# -*- coding: utf-8 -*-
# Problem 31
# Coin sums

# In England the currency is made up of pound, £, and pence, p, and there are
# eight coins in general circulation:

#     1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

# It is possible to make £2 in the following way:

#     1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

# How many different ways can £2 be made using any number of coins?


from time import time

start_time = time()

n = 200
ways = 0
for c1 in range(n / 200 + 1):
    for c2 in range(n / 100 + 1):
        if c1 * 200 > n: break
        for c3 in range(n / 50 + 1):
            if c1 * 200 + c2 * 100 > n: break
            for c4 in range(n / 20 + 1):
                if c1 * 200 + c2 * 100 + c3 * 50 > n: break
                for c5 in range(n / 10 + 1):
                    if c1 * 200 + c2 * 100 + c3 * 50 + c4 * 20 > n: break
                    for c6 in range(n / 5 + 1):
                        if c1 * 200 + c2 * 100 + c3 * 50 + c4 * 20 + c5 * 10 > n: break
                        for c7 in range(n / 2 + 1):
                            if c1 * 200 + c2 * 100 + c3 * 50 + c4 * 20 + c5 * 10 + c6 * 5 > n: break
                            for c8 in range(n + 1):
                                if c1 * 200 + c2 * 100 + c3 * 50 + c4 * 20 + c5 * 10 + c6 * 5 + c7 * 2 > n: break
                                if c1 * 200 + c2 * 100 + c3 * 50 + c4 * 20 + c5 * 10 + c6 * 5 + c7 * 2 + c8 == n:
                                    ways += 1
                                    break       # adding a break here takes off 10 seconds

print ways

print "Total Time: ", time() - start_time

# Completed on Tue, 4 Mar 2014, 16:11
# Solve by: 39270
# ---------------
# 73682
# Total Time:  3.59500002861
# [Finished in 3.8s]
*/

public class Problem31 {

	public static void main(String[] args) {
		int n = 200;
		int ways = 0;
		long start = System.currentTimeMillis();
		
		for (int c1=0; c1 <= n/200; c1++)
			for (int c2=0; c2 <= n/100; c2++) {
				if (c1*200 > n) break;
				for (int c3=0; c3 <= n/50; c3++) {
					if (c1*200+c2*100 > n) break;
				    for (int c4=0; c4 <= n/20; c4++) {
				    	if (c1*200+c2*100+c3*50 > n) break;
				        for (int c5=0; c5 <= n/10; c5++) {
				        	if (c1*200+c2*100+c3*50+c4*20 > n) break;
				            for (int c6=0; c6 <= n/5; c6++) {
				            	if (c1*200+c2*100+c3*50+c4*20+c5*10 > n) break;
				                for (int c7=0; c7 <= n/2; c7++) {
				                	if (c1*200+c2*100+c3*50+c4*20+c5*10+c6*5 > n) break;
				                    for (int c8=0; c8 <= n; c8++) {
				                    	if (c1*200+c2*100+c3*50+c4*20+c5*10+c6*5+c7*2 > n) break;
				                        if (c1*200+c2*100+c3*50+c4*20+c5*10+c6*5+c7*2+c8 == n) {
				                        	ways += 1;
				                        	break;
				                        }
				                    }
				                }
				            }
				        }
				    }
				}
			}
		
		System.out.println(ways);
		System.out.println(System.currentTimeMillis()-start);
	}
}

// Completed on Sun, 19 Apr 2015, 07:01PM
// 73682
// 104