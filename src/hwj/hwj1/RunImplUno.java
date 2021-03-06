package hwj.hwj1;

import hwj.Node;
import hwj.RunImpl;

public class RunImplUno extends RunImpl {

	public RunImplUno(Node n) {
		super(n);
	}

	public long run() {
		long start, end;
		System.out.println("RunImplUno...");
		start = System.nanoTime();
		AdderImplUno d1 = new AdderImplUno();
		Integer sum = d1.computeOnerousSum(this.n);
		System.out.println("Somma RunImpUno: "+sum);
		end = System.nanoTime();
		return end-start;
	}
}
