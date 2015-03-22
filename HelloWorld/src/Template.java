public class Template {

	public static void main(String args[]) {
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

		
		int[][] grid = {{}};
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void method1() {}
	public static void method2() {}
	
}

