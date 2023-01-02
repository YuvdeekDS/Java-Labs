/**
 * 
 */
package lab8_exercise2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * @author 
 *
 */
public class PersonTracker {

	/**
	 * 
	 */
	private ArrayList<Person> peopleList;
	BufferedReader buffReader = null;
	
	public PersonTracker() {
		this.peopleList = new ArrayList<Person>();
	}
	
	public void readTextFile(String filename) {
		String line="";
		try {
			buffReader = new BufferedReader(new FileReader(filename));
			line = buffReader.readLine();
			while (line != null) { //buffer reads the line until EOF reached
				breakLine(line); //call break line to extract it into three words
				line = buffReader.readLine();
			}
		} catch (FileNotFoundException e) {
			//handle I/O Exception if File Not Found Exception arises
			e.printStackTrace();
		} catch (IOException e2) {
			// handle I/O exception while buffer reading the file
			e2.printStackTrace();
		}finally {
			// close the file buffer if exists
			if(buffReader != null) {
				try {
					buffReader.close();
				} catch (IOException e) {
					//handle if any exception arises while closing the buffer
					e.printStackTrace();
				}
			}
		}
	}
	
	private void breakLine(String line) {
		StringTokenizer words = new StringTokenizer(line);
		
		String fname= words.nextToken();
		String sname = words.nextToken();
		int age  = Integer.parseInt(words.nextToken());
		addPerson(fname,sname,age);
	}
	
	private void addPerson(String forename,String surname, int age) {
		Person person = new Person(forename,surname,age);
		peopleList.add(person);
	}
	
	public String displayList() {
		String result="";
		for(Person person :peopleList) {
			result += person.toString()+"\n";
		}
		return result;
	}
	
}
