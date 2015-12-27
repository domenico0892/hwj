package hwj;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class ThreadTask implements Callable<Integer> {

	private Queue<Node> buffer;
	private FakeProcessor fp;
	private ExecutorService es;
	private Adder adder;
	
	public ThreadTask (Queue<Node> b, FakeProcessor fp, ExecutorService es, Adder a) {
		this.buffer = b;
		this.fp = fp;
		this.es = es;
		this.adder = a;
	}
	
	@Override
	public Integer call() throws Exception {
		Node n = this.buffer.poll();
		System.out.println("Visiting "+n.getValue());
		if (n.getDx() != null) {
			this.buffer.offer(n.getDx());
			es.submit(new ThreadTask(this.buffer, this.fp, this.es, this.adder));
		}
		if (n.getSx() != null) {
			this.buffer.offer(n.getSx());
			es.submit(new ThreadTask(this.buffer, this.fp, this.es, this.adder));
		}
		Integer i = this.fp.onerousFunction(n.getValue());
		System.out.println("Value computed for "+n.getValue()+": "+i);
		this.adder.add(i);
		return i;
	}
}
