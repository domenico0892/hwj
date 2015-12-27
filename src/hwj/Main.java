package hwj;

public class Main {
	
	public static void main (String[] args) {
		long start, end;
		double duration1, durationN;
		//Node root = new TreeNode(new TreeNode(new TreeNode(null,null,9),null,1),new TreeNode(new TreeNode(new TreeNode(null,null,4),null,7),null,3),2);
		System.out.println("Creo albero...");
		Node root = createBinaryTree(20);
		System.out.println("Prova 1 thread");
		start = System.nanoTime();
		DomandaUno d1 = new DomandaUno(1, 10000);
		Integer sum1 = d1.computeOnerousSum(root);
		end = System.nanoTime();
		duration1 = (double)(end-start)/1000000;
		System.out.println("Somma1: "+sum1);
		System.out.println("Duration1: "+duration1+" ms");
		System.out.println("Prova "+Runtime.getRuntime().availableProcessors()+" thread");
		start = System.nanoTime();
		DomandaUno d2 = new DomandaUno(Runtime.getRuntime().availableProcessors(), 10000);
		Integer sumN = d2.computeOnerousSum(root);
		end = System.nanoTime();
		durationN = (double)(end-start)/1000000;
		System.out.println("SommaN: "+sumN);
		System.out.println("DurationN: "+durationN+" ms\n");
		System.out.println("SpeedUp: "+(duration1/durationN));
	}
	
	private static Node createBinaryTree(int n) {
		if (n>0) {
			return new TreeNode (createBinaryTree(n-1),createBinaryTree(n-1),(int)(Math.random()*1000));
		}
		else
			return null;
	}

}
