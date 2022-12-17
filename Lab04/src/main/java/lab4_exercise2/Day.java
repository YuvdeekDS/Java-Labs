package lab4_exercise2;

public class Day {
	private String dayName;
	private Session[] sessions;
	
	
	public Day(String dayName) {
		this.dayName = dayName;
		this.sessions = new Session[4];
	}
	
	public void setSession(int index,String moduleName,int startTime,int endTime) {
		sessions[index] = new Session(moduleName,startTime,endTime);
	}
	public String getName() {
		return dayName;
	}
	public String toString() {
		String sessionsString="";
		for (Session single: sessions) {
			if(single ==null)
				return sessionsString;
			else
			sessionsString += single.toString();
		}
		return sessionsString;
	}
	
}
