package Java.Service;

public class StubAuthenticator implements Authenticator {

	@Override
	public boolean authenticate(String login, char[] password) {
		return "foo".equals(login) && "bar".equals(new String(password));
	}

	// Publication is made in the META-INF/services/service.authenticator file
	// A service provider is identified by placing a provider-configuration file
	// in the resource directory META-INF/services. 
	// The file's name is the fully-qualified binary name of the service's type. 
	// The file contains a list of fully-qualified binary names of concrete provider classes, 
	// one per line. 
}
