package hwj.hwj3;

import java.util.concurrent.RecursiveTask;

import hwj.FakeProcessor;
import hwj.Node;

public class AdderTask extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3936417250216150864L;
	private Node n;
	
	public AdderTask (Node n) {
		this.n = n;
	}
	@Override
	protected Integer compute() {
		AdderTask left, right;
		if (this.n != null) {
			FakeProcessor fp = new FakeProcessor(10000);
			left = new AdderTask(n.getDx());
			right = new AdderTask(n.getSx());
			left.fork();
			right.fork();
			return left.join() + right.join() + fp.onerousFunction(this.n.getValue());
		}
		else
			return 0;
	}
}
