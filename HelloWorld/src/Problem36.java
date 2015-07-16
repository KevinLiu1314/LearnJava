/*
# -*- coding: utf-8 -*-
# Problem 36
# Double-base palindromes

# The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.

# Find the sum of all numbers, less than one million, which are palindromic in
# base 10 and base 2.

# (Please note that the palindromic number, in either base, may not include
# leading zeros.)

from time import time
from UsefulFunctions import palindromic

start_time = time()

l = []
i = 1
while i < 1000000:
    if palindromic(str(i)) and palindromic(str(bin(i))[2:]):
        l.append(i)
    i += 1

print l
print sum(l)

print "Total Time: ", time() - start_time

# Completed on Tue, 4 Mar 2014, 21:32
# Solve by: 45334
# ---------------
# [1, 3, 5, 7, 9, 33, 99, 313, 585, 717, 7447, 9009, 15351, 32223, 39993, 53235, 53835, 73737, 585585]
# 872187
# Total Time:  2.20699977875
# [Finished in 2.4s]
 */

public class Problem36 {

	public static void main(String[] args) {
		System.out.println(binaryStr(585));
		System.out.println(Integer.toBinaryString(585));
		System.out.println(isPalindrome("583485"));
		
		int sum = 0;
		for (int i=1; i<1000000; i++) {
			if (isPalindrome(Integer.toString(i)) && isPalindrome(binaryStr(i))) sum += i;
		}
		
		System.out.println("Sum: " + Integer.toString(sum));
		System.out.println("Sum: " + sum);
	}

	public static String binaryStr(int n) {
		String str = "";
		int lastDigit = 0;
		
		while (n>0) {
			lastDigit = n % 2;
			str = Integer.toString(lastDigit) + str;
			n /= 2;
		}
		return str;
	}
	
	public static boolean isPalindrome(String s) {
		for (int i=0; i < s.length()/2; i++) {
			if (!s.substring(i,i+1).equals(s.substring(s.length()-i-1, s.length()-i))) return false; 
		}
		return true;
	}
}

//Completed on Sun, 12 Jul 2015, 6:49PM
//1001001001
//1001001001
//false
//Sum: 872187
//Sum: 872187
