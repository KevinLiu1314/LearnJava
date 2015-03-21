//# Problem 5
//# Smallest multiple
//
//# 2520 is the smallest number that can be divided by each of the numbers
//# from 1 to 10 without any remainder.
//
//# What is the smallest positive number that is evenly divisible by all
//# of the numbers from 1 to 20?

//# Completed on Sat, 1 Mar 2014, 21:53
//# Solve by: 207961
//# ---------------
//# 232792560
//# [Finished in 0.2s]
		
//# Method 1, takes few minutes
//# l = [i for i in range(2, 21)]
//# print l
//# n = 1
//# while True:
//#     if all(n % x == 0 for x in l):
//#         print n
//#         break
//#     n += 1
import java.util.*; 

public class Problem5 {
	public static ArrayList<Integer> pfs(long n) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		
		int d = 2;
		while (n > 1) {
			while (n % d == 0) {
				l.add(d);
				n /= d;
			}
			d++;
		}
		
		return l;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
//		method1(20);
		method2(40);

		System.out.println(pfs(5342931457063200L));
		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Finish in: " + diff);

	}

	public static void method2(int max) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i=2; i<=max; i++) {
			ArrayList<Integer> pfsOfi = pfs(i);
			for (Integer j: pfsOfi) l.remove(j);
			for (Integer j: pfsOfi) l.add(j);
		}
		long n = 1;
		for (Integer j: l) n *= j;
		System.out.println(n);
	}

	private static void method1(int max) {
		long n = 1;
		while (true) {
			boolean allDivisible = true;
			for (int i=2; i<=max; i++) {
				if (n % i != 0) {
					allDivisible = false;
					break;
				}
			}
			if (allDivisible) {
				System.out.println(n);
				break;
			}
			n += 1;
		}
	}
}

//----------------
//5342931457063200
//[2, 2, 2, 2, 2, 3, 3, 3, 5, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]
//Finish in: 3
