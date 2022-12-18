package lab6_exercise2;

import static org.junit.Assert.assertEquals;

public class Halfbacks {

	private Player[] players;
	private  int count =0;
	public Halfbacks() {
		// TODO Auto-generated constructor stub
		players = new Player[2];
	}
 
   public void assignHalfback(Player player) {
	   
	   switch(player.getPosition()) {	   
	   case FLYHALF:
		   players[1] = player;
	   		break;
	   case SCRUMHALF:
		   players[0] = player;
		   	break;
	   default:
		   //nothing
      }
   }
   
   public String getPlayer(RugbyPosition position) {
	   
	   String result;
	   switch(position) {	   
		   case FLYHALF:
		   		result = players[1].getName();
		   		break;
		   case SCRUMHALF:
			   	result = players[0].getName();
			   	break;
		   default:
			    result = "";
	   }
	  return result; 
   }
   public String displayElements() {
	   String displayString="";
		for (int player=0; player<players.length;player++) {
			Player currentPlayer = players[player];
			if(currentPlayer != null)
			displayString += player + " - " + currentPlayer.getName()+" "+ currentPlayer.getPosition().getName() + "\n";
			else
			displayString += player + " - " +  "\n";	
		}
		return displayString;
   }
}
