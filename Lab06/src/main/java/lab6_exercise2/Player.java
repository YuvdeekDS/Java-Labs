package lab6_exercise2;

public class Player {
	private String name;
	private RugbyPosition position;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
 
	public Player(String name, RugbyPosition position) {
		super();
		this.name = name;
		this.position = position;
	}
	/**
	 * @return the position
	 */
	public RugbyPosition getPosition() {
		return position;
	}

	
}
