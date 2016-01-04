package hwj.hwj2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import hwj.BinaryTreeAdder;
import hwj.Node;
import hwj.hwj1.Adder;

public class AdderImplDue implements BinaryTreeAdder {

	
	
	@Override
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
	}

}
