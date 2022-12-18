package exercise1;

/**
 * Class representing attributes and behaviour of a number which when
 * incremented reaches a limit and is then reset to zero.
 * 
 * @author Stella Kazamia
 */
public class NumberInfo {

	/** The number limit. */
	private int limit;

	/** The current number value. */
	private int value = 0;

	/**
	 * Parameterised constructor allowing the limit to be defined and which sets the
	 * initial value to be zero.
	 * 
	 * @param limit
	 *            the number limit.
	 */
	public NumberInfo(int limit) {
		super();
		this.limit = limit;
	}

	/**
	 * @return the current number value.
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Increments the number value taking care of the limit.
	 */
	public void increment() {
		// this.value++;
		// this.value = (this.value) % this.limit;
		this.value = this.value + 1;

		if (this.value == limit) {
			this.value = 0;
		}

	}

}