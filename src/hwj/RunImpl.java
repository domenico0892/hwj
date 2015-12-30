package hwj;

public abstract class RunImpl {

	abstract public void run ();
	
	public static Node createCompleteBinaryTree(int n) {
		if (n>0) {
			return new TreeNode (createCompleteBinaryTree(n-1),createCompleteBinaryTree(n-1),(int)(Math.random()*1000));
		}
		else
			return null;
	}
}
