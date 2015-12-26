package hwj;

public class FakeProcessor implements OnerousProcessor {

	public final static int MIN_COUNT = 1000;
	private int max;
	private java.util.Random random;

	public FakeProcessor (int max) {
		this.max = max;
		this.random = new java.util.Random();
	}

	public int onerousFunction (int value) {
		int r = this.random.nextInt(this.max);
		int n = Math.max(MIN_COUNT, r);
		for (int counter=0; counter<n; counter++) {
			r = this.random.nextInt(this.max);
			r = r ^ this.random.nextInt(this.max);
			r = r ^ this.random.nextInt(this.max);
		}
		return value;
	}
}
