package name_Application;


/**
 * This application converts a name into JSON and XML representations.
 * @author Sascha Baumeister
 */
public class NameJsonAndXmlApp {

	/**
	 * Application entry point
	 * @param args the runtime arguments (first, last and middle name expected)
	 */
	public static void main (String[] args) {
		// create instance "name" of class Name
		final Name name = new Name();
		name.setFirst(args[0]);
		name.setLast(args[1]);
		name.setMiddle(args[2]);

		System.out.println(name.toString());
		System.out.println(name.toJsonString());
		System.out.println(name.toXmlString());
	}
}