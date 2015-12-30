package hwj.hwj1;

import hwj.Node;
import hwj.RunImpl;

public class RunImplUno extends RunImpl {

	@Override
	public void run() {
		long start, end;
		double duration1, durationN;
		//Node root = new TreeNode(new TreeNode(new TreeNode(null,null,9),null,1),new TreeNode(new TreeNode(new TreeNode(null,null,4),null,7),null,3),2);
		System.out.println("Creo albero...");
		Node root = createCompleteBinaryTree(20);
		System.out.println("Prova 1 thread");
		start = System.nanoTime();
		AdderImplUno d1 = new AdderImplUno(1);
		Integer sum1 = d1.computeOnerousSum(root);
		end = System.nanoTime();
		duration1 = (double)(end-start)/1000000;
		System.out.println("Somma1: "+sum1);
		System.out.println("Duration1: "+duration1+" ms");
		System.out.println("Prova "+Runtime.getRuntime().availableProcessors()+" thread");
		start = System.nanoTime();
		AdderImplUno d2 = new AdderImplUno(Runtime.getRuntime().availableProcessors());
		Integer sumN = d2.computeOnerousSum(root);
		end = System.nanoTime();
		durationN = (double)(end-start)/1000000;
		System.out.println("SommaN: "+sumN);
		System.out.println("DurationN: "+durationN+" ms\n");
		System.out.println("SpeedUp: "+(duration1/durationN));
	}
}
