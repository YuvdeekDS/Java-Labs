package lab4_exercise2;

public class Session {
	
	private String sessionName;
	private int startTime;
	private int endTime;
	
	public Session(String sName,int stTime,int eTime) {
		this.sessionName = sName;
		this.startTime = stTime;
		this.endTime = eTime;
	}
	
	public String toString() {
		return sessionName+": "+startTime+" - "+endTime+"\n";
	}
}
