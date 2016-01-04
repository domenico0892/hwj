package hwj.hwj2;

import java.util.List;
import java.util.concurrent.BlockingDeque;

import hwj.FakeProcessor;
import hwj.Node;
import hwj.hwj1.Adder;

public class ThreadTask implements Runnable {
	
	private BlockingDeque<Node> buffer;
	private List<BlockingDeque<Node>> buffers;
	private Adder adder;
	
	public ThreadTask (BlockingDeque<Node> b, List<BlockingDeque<Node>> l, Adder a) {
		this.buffer = b;
		this.buffers = l;
		this.adder = a;
	}

	@Override
	public void run() {
		int sum = 0;
		Node n;
		BlockingDeque<Node> b;
		FakeProcessor f = new FakeProcessor(10000);
		while (true) {
			if ((n = this.buffer.pollLast()) != null) {
				sum += f.onerousFunction(n.getValue());
				if (n.getDx() != null)
					this.buffer.offerLast(n.getDx());
				if (n.getSx() != null)
					this.buffer.offerLast(n.getSx());
			}
			else {
				if ((b = getFirstNotEmpty()) != null) 
					this.buffer.offerLast(b.pollFirst());
				else {
					this.adder.add(sum);
					return;
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
