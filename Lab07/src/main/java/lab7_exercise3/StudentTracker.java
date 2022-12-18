package lab7_exercise3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTracker {

	private List<Student> studentList;
	private Map<Integer, String> moduleList;
	
	/**
	 * Default constructor and used to Initialize then list and map 
	 */
	public StudentTracker() {
		studentList = new ArrayList<Student>();
		this.moduleList = new HashMap<Integer, String>();
	}


	/**
	 *  This is method to add the students along with modules 
	 */
	
	public void addStudent(Student student, List<Module> moduleList) {

	   this.studentList.add(student);	
		for(Module module: moduleList) 
		   student.addModuleList(module);
	   
	   this.moduleList.put(student.getUrn(), student.printModules());
	}
	/**
	 *  Initialize then list and map 
	 */
	
	private void initialiseMap() {
		
		this.moduleList = new HashMap<Integer, String>();
	}
	/**
	 * To print all the students  registered  
	 * Returns the String 
	 */
	
	public String printStudents() {
		
		String output= "";	 
		 for(Student student: this.studentList) {
			 output+= student.getName() + "("+ student.getUrn() + ")"+"\n";
		  }
		  return output;
	}
	
	/**
	 * To print the modules by given Urn 
	 * Returns the String 
	 */
	
	public String printModules(int urn) {
		
		 String result = this.moduleList.get(urn);	   
	  	 return result == null ? "Error" : "URN " + urn + " is enrolled in:\n" + result;
		
		
	}
	

}
