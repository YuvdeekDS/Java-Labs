package lab6_exercise2;

public class Check {

	public Check() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1 = new Player("Rhys Priestland", RugbyPosition.FLYHALF);
		Player player2 = new Player("Mike Phillips", RugbyPosition.SCRUMHALF);
		Halfbacks halfbacks = new Halfbacks();
		halfbacks.assignHalfback(player1);
		halfbacks.assignHalfback(player2);
		System.out.println(halfbacks.displayElements());
	}

}
