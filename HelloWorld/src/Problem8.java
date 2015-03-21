//# Problem 8
//# Largest product in a series
//
//# Find the greatest product of five consecutive digits in the 1000-digit number.
//str = str.replace("\n", "")
//
//products = []
//
//for i in range(len(str) - 5):
//    series = map(lambda x: int(x), list(str[i:i + 5]))
//    products.append(reduce(lambda x, y: x * y, series))
//
//print max(products)
//
//# Completed on Sat, 1 Mar 2014, 23:35
//# Solve by: 159320
//# ---------------
//# 40824
//# [Finished in 0.2s]

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Problem8 {

	public static void main(String[] args) throws Exception {
		String str = new String(readAllBytes(get("/home/kevin/Repositories/LearnJava/HelloWorld/src/Problem8.txt")));
		str = str.replace("\n", "");
		System.out.println(str.length());
		System.out.println(str);
		
		// convert the string into a list of integer digits
		int[] l = new int[str.length()];
		for (int i = 0; i < l.length; i++)
			l[i] = Integer.parseInt(str.charAt(i)+"");
		
		long max = 0;
		long product;
		for (int i = 0; i <= l.length-5; i++) {
			product = l[i] * l[i+1] * l[i+2] * l[i+3] * l[i+4];
			if (product > max)
				max = product;
		}
		
		System.out.println(max);
	}

}

//----------------
//1000
//7316717653133062491922511967442657474235
//40824
