package hwj;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DomandaUno implements BinaryTreeAdder {

	private ExecutorService es;
	
	public DomandaUno (int n) {
		this.es = Executors.newFixedThreadPool(n);
	}
	
	@Override
	public int computeOnerousSum(Node root) {
		// TODO Auto-generated method stub
		return 0;
	}

}
