/**
 * 
 */
package lab8_exercise3;
import java.lang.Exception;
/**
 * @author 
 *
 */
public class InvalidSurnameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -956705286400984022L;
	/**
	 * 
	 */
	public InvalidSurnameException() {
		// TODO Auto-generated constructor stub
		super("Invalid Surname");
	}
	/**
	 * Allow a specific message to be included.
	 * 
	 * @param message The specific message.
	 */
	public InvalidSurnameException(String message) {
		super(message);
	}
}
