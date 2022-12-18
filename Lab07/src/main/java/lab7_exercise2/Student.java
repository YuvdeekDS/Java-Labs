/**
 * 
 */
package lab7_exercise2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LENOVO
 *
 */
public class Student {

	private String name;
	
	private int urn;
	
	private List<Module> moduleList;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the urn
	 */
	public int getUrn() {
		return urn;
	}
    
	/**
	 * @return the void
	 * this method is mainly to add the module to student
	 */
	public void addModuleList(Module module) {
		
		if(!moduleList.contains(module)) {
			moduleList.add(module);
		}
		
	}
	
	
	/**
	 * @param name
	 * @param urn
	 */
	public Student(String name, int urn) {
		this.name = name;
		this.urn = urn;
		moduleList = new ArrayList<Module>();
	}


	/**
	 * @return the String
	 * This is to print the modules of Student
	 */
	public String printModules() {	 	
	 String output= "";	 
	 for(Module module: this.moduleList) {
		 output+= module.getName() + ", ";
	  }
	  return output.substring(0,output.lastIndexOf(","))+" ";
	 }
}
