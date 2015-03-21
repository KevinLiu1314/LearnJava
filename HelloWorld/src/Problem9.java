//# Problem 9
//# Special Pythagorean triplet
//
//# A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//# a^2 + b^2 = c^2
//
//# For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//
//# There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//# Find the product abc.
//
//
//def find_abc():
//    for a in range(1, 1000):
//        for b in range(a + 1, 1000):
//            for c in range(b + 1, 1000):
//                if a + b + c == 1000 and a ** 2 + b ** 2 == c ** 2:
//                    return a, b, c
//
//a, b, c = find_abc()
//
//print "a=%d, b=%d, c=%d" % (a, b, c)
//print a * b * c
//
//# Completed on Sat, 1 Mar 2014, 23:52
//# Solve by: 157435
//# ---------------
//# a=200, b=375, c=425
//# 31875000
//# [Finished in 6.6s]

public class Problem9 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		findABC();

		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Finish in: " + diff);

		start = System.currentTimeMillis();

		findABC2();

		end = System.currentTimeMillis();
		diff = end - start;
		System.out.println("Finish in: " + diff);
	}

	public static void findABC() {
		for (int a = 1; a < 1000; a++)
			for (int b = 1; b < 1000; b++)
				for (int c = 1; c < 1000; c++) {
					if ((a + b + c == 1000) && (a * a + b * b == c * c)) {
						System.out.format("a=%d b=%d c=%d\n", a, b, c);
						return;
					}
				}
	}

	public static void findABC2() {
		for (int a = 1; a < 1000; a++)
			for (int b = a; b < 1000; b++)
				for (int c = b; c < 1000; c++) {
					if ((a + b + c == 1000) && (a * a + b * b == c * c)) {
						System.out.format("a=%d b=%d c=%d\n", a, b, c);
						return;
					}
				}
	}

}

//---------------------
//a=200 b=375 c=425
//Finish in: 148
//a=200 b=375 c=425
//Finish in: 82
