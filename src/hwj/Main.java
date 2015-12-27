package hwj;

public class Main {
	
	public static void main (String[] args) {
		long start, end;
		double duration;
		start = System.nanoTime();
		DomandaUno d1 = new DomandaUno(Runtime.getRuntime().availableProcessors(), 10000);
		Node root = new TreeNode(new TreeNode(new TreeNode(null,null,9),null,1),new TreeNode(new TreeNode(new TreeNode(null,null,4),null,7),null,3),2);
		Integer sum = d1.computeOnerousSum(root);
		end = System.nanoTime();
		duration = (double)(end-start)/1000000;
		System.out.println("Somma: "+sum);
		System.out.println("Available Processors: "+Runtime.getRuntime().availableProcessors());
		System.out.println("Duration: "+duration+" ms");
	}

}
