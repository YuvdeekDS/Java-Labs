package lab4_exercise3;

public class WeekTimetable {
	private Day[] days;
	
	public WeekTimetable (){
		this.days = new Day[5];
		
	}
	public void addDailySessions(int index,Day day) {
		days[index] = day;
	}
	
	public String printTimetable() {
		String weekSchedule = "";
		for (Day single: days) {
			if(single==null)
				return weekSchedule;
			else
				weekSchedule += single.getName()+"\n"+single.toString()+"\n";
		}
		return weekSchedule;
	}
}
