package hwj;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DomandaUno implements BinaryTreeAdder {

	private ExecutorService es;
	private Queue<Node> buffer;
	
	public DomandaUno (int n) {
		this.es = Executors.newFixedThreadPool(n);
		this.buffer = new ConcurrentLinkedQueue<Node>();
	}
	
	@Override
	public int computeOnerousSum(Node root) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void buildQueue(Node root) {
		this.buffer.offer(root);
		Future<?> f = this.es.submit(
				new Runnable() {
					public void run () {
						Node n = this.buffer.poll();
					}
				}
				
	}

}
