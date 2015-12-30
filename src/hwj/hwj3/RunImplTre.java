package hwj.hwj3;

import hwj.Node;
import hwj.RunImpl;
import hwj.hwj3.AdderImplTre;

public class RunImplTre extends RunImpl {

	public RunImplTre(Node n) {
		super(n);
	}

	public long run () {
		long start, end;
		System.out.println("RunImplTre...");
		start = System.nanoTime();
		AdderImplTre d1 = new AdderImplTre();
		@SuppressWarnings("unused")
		Integer sum1 = d1.computeOnerousSum(this.n);
		end = System.nanoTime();
		return end-start;
	}
}

