package hwj;

import hwj.hwj1.RunImplUno;
import hwj.hwj2.RunImplDue;
import hwj.hwj3.RunImplTre;

public class Main {

	public static void main (String[] args) {
		long start,end,dur0,dur1,dur2,dur3;
		Node n = createCompleteBinaryTree(20);
		start = System.nanoTime();
		System.out.println("SimpleSumTree...");
		Integer sum = simpleSumTree(n);
		System.out.println("Somma SimpleSumTree: "+sum);
		end = System.nanoTime();
		dur0 = end-start;
		RunImpl r = new RunImplUno(n);
		dur1 = r.run();
		r = new RunImplDue(n);
		dur2 = r.run();
		r = new RunImplTre(n);
		dur3 = r.run();
		System.out.println("Durata senza thread: "+dur0);
		System.out.println("Durata RunImplUno: "+dur1);
		System.out.println("Durata RunImplDue: "+dur2);
		System.out.println("Durata RunImplTre: "+dur3);
		System.out.println("Speedup RunImplUno: "+(double)dur0/dur1);
		System.out.println("Speedup RunImplDue: "+(double)dur0/dur2);
		System.out.println("Speedup RunImplTre: "+(double)dur0/dur3);
	}
	public static Node createCompleteBinaryTree(int n) {
		if (n>0) {
			return new TreeNode (createCompleteBinaryTree(n-1),createCompleteBinaryTree(n-1),(int)(Math.random()*1000));
		}
		else
			return null;
	}


	public static Integer simpleSumTree (Node n) {
		FakeProcessor f = new FakeProcessor(10000);
		if (n!=null) {
			return simpleSumTree(n.getDx()) + simpleSumTree(n.getSx()) + f.onerousFunction(n.getValue());
		}
		else 
			return 0;
	}
}