//# Problem 16
//# Power digit sum
//
//# 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//
//# What is the sum of the digits of the number 2^1000?
//
//n = map(lambda x: int(x), list(str(2 ** 1000)))
//print sum(n)
//
//# Completed on Sun, 2 Mar 2014, 05:45
//# Solve by: 107260
//# ---------------
//# 1366
//# [Finished in 0.1s]

import java.math.BigInteger;

public class Problem16 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		method1();
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Method1 Finish in: " + diff);

		start = System.currentTimeMillis();
		method2();
		end = System.currentTimeMillis();
		diff = end - start;
		System.out.println("Method2 Finish in: " + diff);
		
		System.out.println(new BigInteger("0").equals("0"));
		System.out.println(new BigInteger("0").equals(new BigInteger("0")));
	}

	public static void method1() {
		BigInteger num = new BigInteger("2");
		String str = new String(num.pow(1000).toString());
		
		long sum = 0;
		
		for (int i = 0; i < str.length(); i++)
			sum += Integer.parseInt(str.charAt(i) + "");

		System.out.println(sum);
	}

	public static void method2() {
		BigInteger num = new BigInteger("2").pow(1000);
		
		BigInteger sum = BigInteger.ZERO;
		BigInteger TEN = new BigInteger("10");
		while (!num.equals(BigInteger.ZERO)) {
			sum = sum.add(num.mod(TEN));
			num = num.divide(TEN);
		}
		
		System.out.println(sum);
	}
}

//Completed on Sat, 21 Mar 2015, 08:09PM
//1366
//Method1 Finish in: 4
//1366
//Method2 Finish in: 3