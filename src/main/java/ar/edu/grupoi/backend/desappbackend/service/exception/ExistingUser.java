package ar.edu.grupoi.backend.desappbackend.service.exception;

public class ExistingUser extends Exception {

	public ExistingUser() {
		super("Is there a user with this mail");
	}

}
