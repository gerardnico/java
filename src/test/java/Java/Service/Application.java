package Java.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Application {
	public static void main(String args[]) {

		Authenticator authenticator = getAuthenticator();
		if (authenticator == null) {
			System.err.println("Unable to locate the Authentication Service");
			System.exit(1);
		}

        String login = "foo";
		char[] password = "bar".toCharArray();

		if (authenticator.authenticate(login, password)) {
			System.out.println("Authentication successful, welcome " + login
					+ " :-)");
		} else {
			System.out.println("Login or password invalid !");
		}
	}

	/**
	 * Get the service provider
	 */
	public static Authenticator getAuthenticator() {

        Authenticator authenticator = null;

		ServiceLoader<Authenticator> serviceLoader = ServiceLoader
				.load(Authenticator.class);

		Iterator<Authenticator> iterator = serviceLoader.iterator();

		if (iterator.hasNext()) {

			authenticator = iterator.next();

		}
		return authenticator;
	}
}
