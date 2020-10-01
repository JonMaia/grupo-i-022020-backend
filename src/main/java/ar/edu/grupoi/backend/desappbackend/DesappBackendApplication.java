package ar.edu.grupoi.backend.desappbackend;

import java.time.LocalDate;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.repositories.DonorRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.LocationRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.ProjectRepository;
import ar.edu.grupoi.backend.desappbackend.service.builder.DonorBuilder;
import ar.edu.grupoi.backend.desappbackend.service.builder.LocationBuilder;
import ar.edu.grupoi.backend.desappbackend.service.builder.ProjectBuilder;

@SpringBootApplication
public class DesappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesappBackendApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(DonorRepository donorRepository, LocationRepository locationRepository, ProjectRepository projectRepository) {
		return args -> {
			
			Donor cris = DonorBuilder.whitName("Cristian")
					.whitMail("cris@mail.com")
					.whitPassword("cris123")
					.withNickname("Cris").builder();
			
			Donor jony = DonorBuilder.whitName("Jonathan")
					.whitMail("jony@mail.com")
					.whitPassword("jony213")
					.withNickname("Jony").builder();
			
			Location avellaneda = LocationBuilder.withName("Avellaneda")
					.whitProvince("Buenos Aires")
					.whitPopulation(342677)
					.withState(true).builder();
			
			Project project = ProjectBuilder.withName("Avellaneda con Internet")
					.withEndDate(LocalDate.of(2020,11,23))
					.withLocation(avellaneda)
					.withFactor(50.0)
					.withInitialDate(LocalDate.now())
					.builder();
        
			Location quilmes = LocationBuilder.withName("Quilmes")
					.whitProvince("Buenos Aires")
					.whitPopulation(542677)
					.withState(true).builder();
			
			Project otherProject = ProjectBuilder.withName("Quilmes con Internet")
					.withEndDate(LocalDate.of(2020,11,23))
					.withLocation(quilmes)
					.withFactor(50.0)
					.withInitialDate(LocalDate.now())
					.builder();
			
			donorRepository.save(cris);
			donorRepository.save(jony);
			locationRepository.save(avellaneda);
			locationRepository.save(quilmes);
			projectRepository.save(project);
			projectRepository.save(otherProject);
		};

	}
}
