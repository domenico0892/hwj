package hwj.hwj3;

import java.util.concurrent.RecursiveTask;

import hwj.FakeProcessor;
import hwj.Node;

public class AdderTask extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private final int SEQUENTIAL_THRESHOLD = 15;

	private static final long serialVersionUID = -3936417250216150864L;
	private Node n;
	private int level;

	public AdderTask (Node n, int l) {
		this.n = n;
		this.level = l;
	}
	@Override
	protected Integer compute() {
		AdderTask left, right;
		if (this.n != null) {
			FakeProcessor fp = new FakeProcessor(10000);
			if (this.level<=this.SEQUENTIAL_THRESHOLD) {
				left = new AdderTask(n.getDx(),this.level+1);
				right = new AdderTask(n.getSx(),this.level+1);
				left.fork();
				right.fork();
				return left.join() + right.join() + fp.onerousFunction(this.n.getValue());
			}
			else {
				return sumSubTree(n);
			}

		}
		else
			return 0;
	}

	private Integer sumSubTree (Node n) {
		if (n == null)
			return 0;
		else {
			FakeProcessor fp = new FakeProcessor(10000);
			return sumSubTree(n.getDx()) + sumSubTree(n.getSx()) + fp.onerousFunction(n.getValue());
		}
	}
}
