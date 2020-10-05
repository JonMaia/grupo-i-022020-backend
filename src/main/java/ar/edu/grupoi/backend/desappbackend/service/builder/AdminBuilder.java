package ar.edu.grupoi.backend.desappbackend.service.builder;

import ar.edu.grupoi.backend.desappbackend.model.user.Admin;

public class AdminBuilder {

	private String name;
	private String mail;
	private String password;

	public static AdminBuilder whitName(String name) {
		AdminBuilder builder = new AdminBuilder();
		builder.name = name;
		return builder;
	}

	public Admin builder() {
		return new Admin(name, mail, password);
	}

	public AdminBuilder whitMail(String mail) {
		this.mail = mail;
		return this;
	}

	public AdminBuilder whitPassword(String password) {
		this.password = password;
		return this;
	}

}
