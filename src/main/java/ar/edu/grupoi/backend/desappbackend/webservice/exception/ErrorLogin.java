package ar.edu.grupoi.backend.desappbackend.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "No such order")
public class ErrorLogin extends Exception {

	public ErrorLogin() {
		super("Incorrect mail or password");
	}
}
