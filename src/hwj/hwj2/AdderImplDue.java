package hwj.hwj2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

import hwj.BinaryTreeAdder;
import hwj.Node;

public class AdderImplDue implements BinaryTreeAdder {

	private ExecutorService es;
	
	public AdderImplDue () {
		this.es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	@Override
	public int computeOnerousSum(Node root) {
		Integer sum = 0;
		List<BlockingDeque<Node>> buffers = new ArrayList<BlockingDeque<Node>>(Runtime.getRuntime().availableProcessors());
		List<ThreadTask> threads = new ArrayList<ThreadTask>(Runtime.getRuntime().availableProcessors());
		List<Future<Integer>> future = new ArrayList<Future<Integer>>(Runtime.getRuntime().availableProcessors());
		for (int i=0;i<Runtime.getRuntime().availableProcessors();i++) {
			BlockingDeque<Node> b = new LinkedBlockingDeque<Node>();
			buffers.add(b);
			ThreadTask t = new ThreadTask(buffers.get(i), buffers);
			threads.add(t);
		}
		buffers.get(0).offerFirst(root);
		for (int i=0;i<Runtime.getRuntime().availableProcessors();i++) {
			future.add(this.es.submit(threads.get(i)));
		}
		for (int i=0;i<Runtime.getRuntime().availableProcessors();i++) {
			try {
				sum += future.get(i).get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.es.shutdown();
		return sum;
	}
	
	/*@Override
	public int computeOnerousSum(Node root) {
		Adder a = new Adder(0);
		List<BlockingDeque<Node>> buffers = new ArrayList<BlockingDeque<Node>>(Runtime.getRuntime().availableProcessors());
		List<Thread> threads = new ArrayList<Thread>(Runtime.getRuntime().availableProcessors());
		for (int i=0;i<Runtime.getRuntime().availableProcessors();i++) {
			BlockingDeque<Node> b = new LinkedBlockingDeque<Node>();
			buffers.add(b);
			ThreadTask t = new ThreadTask(buffers.get(i), buffers, a);
			threads.add(new Thread(t));
		}
		buffers.get(0).offerFirst(root);
		for (Thread t : threads)
			t.start();
		for (Thread t : threads)
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return a.getSum();
	}*/
	
	
	
	

}
