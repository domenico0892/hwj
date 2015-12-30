package hwj.hwj3;

import java.util.concurrent.ForkJoinPool;

import hwj.BinaryTreeAdder;
import hwj.Node;

public class AdderImplTre implements BinaryTreeAdder{
	
	private ForkJoinPool f;
	static final int SEQUENTIAL_THRESHOLD = 5000;
	
	public AdderImplTre () {
		this.f = new ForkJoinPool();
	}

	@Override
	public int computeOnerousSum(Node root) {
		return this.f.invoke(new AdderTask(root));
	}
	
}
