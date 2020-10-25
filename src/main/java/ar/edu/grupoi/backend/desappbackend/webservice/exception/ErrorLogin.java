package ar.edu.grupoi.backend.desappbackend.webservice.exception;

public class ErrorLogin extends Exception {

	public ErrorLogin() {
		super("Incorrect mail or password");
	}
}
