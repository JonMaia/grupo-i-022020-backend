package ar.edu.grupoi.backend.desappbackend.builder;
import com.somospnt.test.builder.AbstractPersistenceBuilder;

import ar.edu.grupoi.backend.desappbackend.model.user.Donor;

public class DonorBuilder extends AbstractPersistenceBuilder<Donor>{

	private DonorBuilder() {
		
		instance = new Donor();
		instance.setName("Cristian");
		instance.setMail("cris@mail.com");
		instance.setPassword("pas123");
		instance.setNickname("cris");
	}

	public static AbstractPersistenceBuilder<Donor> whitName(String name) {
		DonorBuilder builder = new DonorBuilder();
		builder.instance.setName(name);
		return builder;
	}
	
	public DonorBuilder whitMail(String mail) {
		instance.setMail(mail);
		return this;
	}

	public DonorBuilder whitPassword(String password) {
		instance.setPassword(password);
		return this;
	}

	public DonorBuilder withNickname(String nickname) {
		instance.setNickname(nickname);
		return this;
	}
	
}
