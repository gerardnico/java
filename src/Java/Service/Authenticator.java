package Java.Service;

// Interface Service
public interface Authenticator {

	/**
	 * 
	 * @param login
	 * @param password
	 * @return true if authentication is successful
	 */
	boolean authenticate(String login, char[] password);
	
}
