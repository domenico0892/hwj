package hwj;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DomandaUno implements BinaryTreeAdder {

	private ExecutorService es;
	private Queue<Node> buffer;
	private Adder adder;
	private FakeProcessor fp;

	public DomandaUno (int n, int fp) {
		this.es = Executors.newFixedThreadPool(n);
		this.buffer = new ConcurrentLinkedQueue<Node>();
		this.adder = new Adder(0);
		this.fp = new FakeProcessor(fp);
	}

	@Override
	public int computeOnerousSum(Node root) {
		this.buffer.offer(root);
		ThreadTask t = new ThreadTask (this.buffer, this.fp, this.es, this.adder);
		this.es.submit(t);
		try {
			this.es.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.adder.getSum();
	}	

	public Queue<Node> getBuffer () {
		return this.buffer;
	}
}
