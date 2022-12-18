/**
 * 
 */
package exercise3;

/**
 * @author LENOVO
 *
 */
public class Assessment {

	/**
	 * 
	 */
	public Assessment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mark
	 */
	public double getMark() {
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(double mark) {
		this.mark = mark;
	}

	private String name;
	private int maximum = 100;
	/**
	 * @return the maximum
	 */
	public int getMaximum() {
		return maximum;
	}

	/**
	 * @param maximum the maximum to set
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	private double mark;
	@Override
	public String toString() {
		return "Assessment [name=" + name + ", maximum=" + maximum + ", mark=" + mark + "]";
	}
	public Assessment(String name, double mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	public Assessment(int maximum) {
		super();	 
		this.maximum = maximum;
	}
	
	
	
	
}
