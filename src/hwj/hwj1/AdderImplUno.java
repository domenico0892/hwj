package hwj.hwj1;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import hwj.BinaryTreeAdder;
import hwj.Node;

public class AdderImplUno implements BinaryTreeAdder {

	private ExecutorService es;
	private Queue<Node> buffer;
	private Adder adder;

	public AdderImplUno (int n) {
		this.es = Executors.newFixedThreadPool(n);
		this.buffer = new ConcurrentLinkedQueue<Node>();
		this.adder = new Adder(0);
	}

	@Override
	public int computeOnerousSum(Node root) {
		this.buffer.offer(root);
		ThreadTask t = new ThreadTask (this.buffer, this.es, this.adder);
		this.es.submit(t);
		try {
			System.out.println(this.es.awaitTermination(5, TimeUnit.MINUTES));
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
