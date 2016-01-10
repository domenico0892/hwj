package hwj.hwj2;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;

import hwj.FakeProcessor;
import hwj.Node;

public class ThreadTask implements Callable<Integer> {
	
	private BlockingDeque<Node> buffer;
	private List<BlockingDeque<Node>> buffers;
	
	public ThreadTask (BlockingDeque<Node> b, List<BlockingDeque<Node>> l){
		this.buffer = b;
		this.buffers = l;
	}

	@Override
	public Integer call() {
		int sum = 0;
		Node n;
		BlockingDeque<Node> b;
		FakeProcessor f = new FakeProcessor(10000);
		while (true) {
			if ((n = this.buffer.pollLast()) != null) {
				if (n.getDx() != null)
					this.buffer.offerLast(n.getDx());
				if (n.getSx() != null)
					this.buffer.offerLast(n.getSx());
				sum += f.onerousFunction(n.getValue());
			}
			else {
				if ((b = getFirstNotEmpty()) != null) 
					this.buffer.offerLast(b.pollFirst());
				else {
					return sum;
				}
			}
		}
	}
	
	public BlockingDeque<Node> getFirstNotEmpty () {
		for (BlockingDeque<Node> b : this.buffers) {
			if (!b.isEmpty())
				return b;
		}
		return null;
	}
}
