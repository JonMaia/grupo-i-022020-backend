package ar.edu.grupoi.backend.desappbackend;

import java.time.LocalDate;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import ar.edu.grupoi.backend.desappbackend.dto.DtoDonation;
import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.repositories.AdminRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.DonorRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.LocationRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.ProjectRepository;
import ar.edu.grupoi.backend.desappbackend.service.DonorService;
import ar.edu.grupoi.backend.desappbackend.service.builder.AdminBuilder;
import ar.edu.grupoi.backend.desappbackend.service.builder.DonorBuilder;
import ar.edu.grupoi.backend.desappbackend.service.builder.LocationBuilder;
import ar.edu.grupoi.backend.desappbackend.service.builder.ProjectBuilder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DesappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesappBackendApplication.class, args);
	}
/*
	@Bean
	ApplicationRunner applicationRunner(AdminRepository adminRepository, DonorRepository donorRepository, LocationRepository locationRepository,
			ProjectRepository projectRepository, DonorService donorService) {
		return args -> {
			
			Admin admin = AdminBuilder.whitName("Admin").whitMail("admin@mail.com").whitPassword("admin123")
					.builder();

			Donor cris = DonorBuilder.whitName("Cristian").whitMail("cris.esroj@gmail.com").whitPassword("cris123")
					.withNickname("Cris").builder();

			Donor jony = DonorBuilder.whitName("Jonathan").whitMail("jony_wilde05@hotmail.com").whitPassword("jony213")
					.withNickname("Jony").builder();

			Location avellaneda = LocationBuilder.withName("Avellaneda").whitProvince("Buenos Aires")
					.whitPopulation(342677).withState(true).builder();

			Project project = ProjectBuilder.withName("Avellaneda con Internet").withEndDate(LocalDate.of(2020, 12, 2))
					.withLocation(avellaneda).withFactor(50.0).withInitialDate(LocalDate.now()).builder();

			Location quilmes = LocationBuilder.withName("Quilmes").whitProvince("Buenos Aires").whitPopulation(1500)
					.withState(true).builder();

			Project otherProject = ProjectBuilder.withName("Quilmes con Internet")
					.withEndDate(LocalDate.of(2020, 11, 23)).withLocation(quilmes)
					.withInitialDate(LocalDate.now()).builder();
			
			Location varela = LocationBuilder.withName("Varela").whitProvince("Buenos Aires").whitPopulation(1500)
					.withState(true).builder();

			Project varelaProject = ProjectBuilder.withName("Varela con Internet")
					.withEndDate(LocalDate.of(2020, 12, 23)).withLocation(varela).withFactor(50.0)
					.withInitialDate(LocalDate.now()).builder();

			adminRepository.save(admin);
			donorRepository.save(cris);
			donorRepository.save(jony);
			locationRepository.save(avellaneda);
			locationRepository.save(quilmes);
			locationRepository.save(varela);
			projectRepository.save(project);
			projectRepository.save(otherProject);
			projectRepository.save(varelaProject);
			
			DtoDonation donationVarela = new DtoDonation();
			donationVarela.setIdDonor(2);
			donationVarela.setIdProject(9);
			donationVarela.setAmount(100000);
			donationVarela.setComment("first donation");
			donorService.donate(donationVarela);
			
			DtoDonation donationQuilmes = new DtoDonation();
			donationQuilmes.setIdDonor(2);
			donationQuilmes.setIdProject(8);
			donationQuilmes.setAmount(10000);
			donationQuilmes.setComment("first donation");
			donorService.donate(donationQuilmes);
		};

	}*/
}
