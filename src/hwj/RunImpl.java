package hwj;

public abstract class RunImpl {

	protected Node n;
	
	public RunImpl (Node n) {
		this.n = n;
	}
	
	abstract public long run ();
}
