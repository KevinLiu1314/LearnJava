/*# Problem 20
# Factorial digit sum

# n! means n X (n - 1) X ... X 3 X 2 X 1

# For example, 10! = 10 X 9 X ... X 3 X 2 X 1 = 3628800,
# and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

# Find the sum of the digits in the number 100!

import math

f = math.factorial(100)
f_digits = map(lambda x: int(x), list(str(f)))
print sum(f_digits)

# Completed on Mon, 3 Mar 2014, 01:49
# Solve by: 98269
# ---------------
# 648
# [Finished in 0.2s]
*/

import java.math.BigInteger;

public class Problem20 {

	public static void main(String[] args) {
		BigInteger f100 = new BigInteger("1");
		for (int i = 2; i <= 100; i++)
			f100 = f100.multiply(BigInteger.valueOf(i));
		
		String str = f100.toString();
		int[] digits = new int[str.length()];
		for (int i = 0; i < str.length(); i++)
			digits[i] = Integer.parseInt(str.charAt(i) + "");
		
		long sum = 0;
		for (int i = 0; i < digits.length; i++)
			sum += digits[i];
		
		System.out.println(sum);
	}

}

//Completed on Sun, 22 Mar 2015, 06:21PM
//648