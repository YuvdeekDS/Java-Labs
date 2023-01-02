/**
 * 
 */
package lab8_exercise1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author LENOVO
 *
 */
public class Counting {

	/**
	 * 
	 */
	BufferedReader buffReader = null;

	// Attempt to open the file.

	public Counting() {
		// Initialize Buffer with File Reader including try catch for File Not Found Exception
		try {
			buffReader = new BufferedReader(new FileReader("words.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String readTextFile() {
		String result = ""; // empty string
		try {
			String line = buffReader.readLine();
			int count = 1;
			while (line != null) {   // continue loop until EOF is reached by Buffer reader
				result += displayLine(line, count);
				line = buffReader.readLine();
				count++;
			}

		} catch (IOException e) {
			// Catch the IO Exception when buffer reads the file
			e.printStackTrace();
		} finally {
			// finally close the  buffer if exists
			if (buffReader != null) {
				try {
					buffReader.close();
				} catch (IOException e2) {
					// catch the exception if any while closing the buffer
					e2.printStackTrace();
				}
			}
		}
		return result;
	}

	private String displayLine(String currLine, int counter) {
		return currLine + " : " + counter + "\n"; //format the string as required
	}
}
