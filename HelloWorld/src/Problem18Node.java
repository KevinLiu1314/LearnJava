public class Problem18Node {
	private long sum;
	private int i;
	private int j;
	
	public long sum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	public int i() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int j() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
	public Problem18Node(long sum, int i, int j) {
		this.sum = sum;
		this.i = i;
		this.j = j;
	}
}
