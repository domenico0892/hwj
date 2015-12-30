package hwj.hwj1;

public class Adder {
	
	private Integer sum;
	
	public Adder (Integer init) {
		this.sum = init;
	}
	
	public synchronized Integer add(Integer i) {
		this.sum = this.sum + i;
		return this.sum;
	}
	
	public synchronized Integer getSum() {
		return this.sum;
	}

}
