package hwj;

public class Main {
	
	public static void main (String[] args) {
		long start, end;
		double duration;
		start = System.nanoTime();
		System.out.println("Available Processors: "+Runtime.getRuntime().availableProcessors());
		end = System.nanoTime();
		duration = (double)(end-start)/1000000;
		System.out.println("Duration: "+duration+" ms");
	}

}
