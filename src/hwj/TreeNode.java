package hwj;

public class TreeNode implements Node {

	private Node sx;
	private Node dx;
	private int value;

	public TreeNode (Node sx, Node dx, int value) {
		this.sx = sx;
		this.dx = dx;
		this.value = value;
	}

	public Node getSx() {
		return sx;
	}

	public void setSx(Node sx) {
		this.sx = sx;
	}

	public Node getDx() {
		return dx;
	}

	public void setDx(Node dx) {
		this.dx = dx;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
