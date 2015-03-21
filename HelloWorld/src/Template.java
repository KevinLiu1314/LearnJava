public class Template {

	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		

		
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println("Finish in: " + diff);
		
		int[][] grid = {{}};
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}

