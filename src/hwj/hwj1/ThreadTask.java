package hwj.hwj1;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import hwj.FakeProcessor;
import hwj.Node;

public class ThreadTask implements Callable<Integer> {

	private Queue<Node> buffer;
	private ExecutorService es;
	private Adder adder;
	
	public ThreadTask (Queue<Node> b, ExecutorService es, Adder a) {
		this.buffer = b;
		this.es = es;
		this.adder = a;
	}
	
	@Override
	public Integer call() throws Exception {
		Node n = this.buffer.poll();
		//System.out.println("Visiting "+n.getValue());
		if (n.getDx() != null) {
			this.buffer.offer(n.getDx());
			es.submit(new ThreadTask(this.buffer, this.es, this.adder));
		}
		if (n.getSx() != null) {
			this.buffer.offer(n.getSx());
			es.submit(new ThreadTask(this.buffer, this.es, this.adder));
		}
		if (n.getDx() == null && n.getSx() == null && this.buffer.isEmpty())
			this.es.shutdown();
		FakeProcessor f = new FakeProcessor(10000);
		Integer i = f.onerousFunction(n.getValue());
		//System.out.println("Value computed for "+n.getValue()+": "+i);
		this.adder.add(i);
		return i;
	}
}
