package ar.edu.grupoi.backend.desappbackend.webservice.exception;

public class ExistingUser extends Exception {

	public ExistingUser() {
		super("Is there a user with this mail");
	}
}
