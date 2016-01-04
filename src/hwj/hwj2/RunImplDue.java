package hwj.hwj2;

import hwj.Node;
import hwj.RunImpl;

public class RunImplDue extends RunImpl {

	public RunImplDue(Node n) {
		super(n);
	}

	public long run() {
		long start, end;
		System.out.println("RunImplDue...");
		start = System.nanoTime();
		AdderImplDue d1 = new AdderImplDue();
		Integer sum = d1.computeOnerousSum(this.n);
		System.out.println("Somma RunImpDue: "+sum);
		end = System.nanoTime();
		return end-start;
	}
}
