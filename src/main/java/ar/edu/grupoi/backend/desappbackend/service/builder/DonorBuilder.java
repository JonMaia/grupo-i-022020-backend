package ar.edu.grupoi.backend.desappbackend.service.builder;

import ar.edu.grupoi.backend.desappbackend.model.user.Donor;

public class DonorBuilder {

	private String name;
	private String mail;
	private String password;
	private String nickname;

	public static DonorBuilder whitName(String name) {
		DonorBuilder builder = new DonorBuilder();
		builder.name = name;
		return builder;
	}

	public Donor builder() {
		return new Donor(name, mail, password, nickname);
	}

	public DonorBuilder whitMail(String mail) {
		this.mail = mail;
		return this;
	}

	public DonorBuilder whitPassword(String password) {
		this.password = password;
		return this;
	}

	public DonorBuilder withNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

}
