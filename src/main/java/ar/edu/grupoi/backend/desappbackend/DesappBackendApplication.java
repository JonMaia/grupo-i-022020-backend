package ar.edu.grupoi.backend.desappbackend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

	@Bean
	ApplicationRunner applicationRunner(AdminRepository adminRepository, DonorRepository donorRepository, LocationRepository locationRepository,
			ProjectRepository projectRepository, DonorService donorService) {
		return args -> {

			int minFactor = 0;
			int maxFactor = 100000;
			int minPercentage = 50;
			int maxPercentage = 100;
			int minPopulation = 1000;
			int maxPopulation = 100000;
			long minDay = LocalDate.of(2020, 12, 24).toEpochDay();
			long maxDay = LocalDate.of(2024, 12, 24).toEpochDay();
			long oldMinDay = LocalDate.of(2017, 12, 24).toEpochDay();
			long oldMaxDay = LocalDate.of(2020, 8, 24).toEpochDay();

			List<String> locations = new ArrayList<String>(
					Arrays.asList("Avellaneda", "Gerli", "Sarandi", "Villa Dominico", "Wilde", "Don Bosco", "Bernal",
							"Quilmes", "Solano", "Berazategui", "Varela", "Dock Sud", "Banfield", "Lanus", "Lomas de Zamora",
							"Adrogue", "Alejando Korn", "Bosques", "Cañuelas", "El Pato", "Ezpeleta", "Temperley", "Turdera")
			);

			locations.forEach((locationName) -> {
				Location location = LocationBuilder.withName(locationName).whitProvince("Buenos Aires")
						.whitPopulation((int)(Math.random() * (maxPopulation - minPopulation + 1) + minPopulation))
						.withState(true).builder();
				Project project = ProjectBuilder.withName(locationName + " con Internet")
						.withEndDate(LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(minDay, maxDay)))
						.withLocation(location).withFactor((int) (Math.random() * (maxFactor - minFactor + 1)) +minFactor)
						.withInitialDate(LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(oldMinDay, oldMaxDay)))
						.whitMinPercentage((int)(Math.random() * (maxPercentage - minPercentage + 1)+ minPercentage))
						.builder();

				locationRepository.save(location);
				projectRepository.save(project);
			});

			Admin admin = AdminBuilder.whitName("Admin").whitMail("admin@gmail.com").whitPassword("admin123")
					.builder();

			Donor cris = DonorBuilder.whitName("Cristian").whitMail("cris.esroj@gmail.com").whitPassword("cris123")
					.withNickname("Cris").builder();

			Donor jony = DonorBuilder.whitName("Jonathan").whitMail("jony_wilde05@hotmail.com").whitPassword("jony213")
					.withNickname("Jony").builder();

			adminRepository.save(admin);
			donorRepository.save(cris);
			donorRepository.save(jony);

			projectRepository.findAll().forEach((project) -> {
					DtoDonation donation = new DtoDonation();
					donation.setIdDonor((int) (Math.random() * (cris.getId() - jony.getId())) + cris.getId());
					donation.setIdProject(project.getId());
					donation.setAmount((int) (project.getFactor()));
					donation.setComment(jony.getNickname() + ": I donate to " + project.getName());
					donorService.donate(donation);
			});

			for (int i = 0; i < 10; i++) {
				int finalI = i;
				projectRepository.findAll().forEach((project) -> {
					if (finalI % 2 == 0) {
						DtoDonation donation = new DtoDonation();
						donation.setIdDonor((int) (Math.random() * (cris.getId() - jony.getId())) + cris.getId());
						donation.setIdProject(project.getId());
						donation.setAmount((int) (project.getFactor()));
						donation.setComment(jony.getNickname() + ": I donate to " + project.getName());
						donorService.donate(donation);
					}
				});
			}
		};

	}
}
