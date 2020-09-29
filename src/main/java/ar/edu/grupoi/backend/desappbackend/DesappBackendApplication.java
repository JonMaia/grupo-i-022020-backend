package ar.edu.grupoi.backend.desappbackend;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.repositories.DonorRepository;
import ar.edu.grupoi.backend.desappbackend.service.builder.DonorBuilder;

@SpringBootApplication
public class DesappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesappBackendApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(DonorRepository donorRepository) {
		return args -> {
			Donor cris = DonorBuilder.whitName("Cristian")
					.whitMail("cris@mail.com")
					.whitPassword("cris123")
					.withNickname("Cris").builder();
			
			Donor jony = DonorBuilder.whitName("Jonathan")
					.whitMail("jony@mail.com")
					.whitPassword("jony213")
					.withNickname("Jony").builder();
			donorRepository.save(cris);
			donorRepository.save(jony);
		};

	}
}
