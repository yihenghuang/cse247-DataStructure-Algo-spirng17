package studio0.allocates;

import timing.ExecuteAlgorithm;
import timing.Ticker;
import timing.quiet.QuietAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;


public class Allocates extends QuietAlgorithm {

	protected int[] array;
	protected Ticker ticker;

	public Allocates() {

	}

	/**
	 * Begin with an array of two elements.
	 */
	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
	}

	/**
	 * As a "quiet" algorithm, all we care about is the size
	 * parameter.
	 */
	@Override
	public void run() {
		//
		// We loop so that the allocation takes place many times,
		//   so that its time shows up in the milliseconds range
		//
		for (int i=0; i < 100000; ++i) {
			//
			// Allocate this.size integers
			//
			this.array = new int[this.size];
		}
	}
	
	public String toString() {
		return "Allocation of " + size + " integers";
	}

	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(0, 10000, 500);
		ExecuteAlgorithm.timeAlgorithm(
				"allocates", 
				"studio0.Allocates", 
				new IntArrayGenerator(), 
				sizes
				);	
	}

}