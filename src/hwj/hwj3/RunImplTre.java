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
		Integer sum = d1.computeOnerousSum(this.n);
		System.out.println("Somma RunImpTre: "+sum);
		end = System.nanoTime();
		return end-start;
	}
}

