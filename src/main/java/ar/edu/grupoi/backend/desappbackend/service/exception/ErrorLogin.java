package ar.edu.grupoi.backend.desappbackend.service.exception;

public class ErrorLogin extends Exception {

	public ErrorLogin() {
		super("Incorrect mail or password");
	}

}
