package ar.edu.grupoi.backend.desappbackend.model.project;

import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class System {

    public final ArrayList<Donation> donations;
    public final ArrayList<Location> locations;
    public final ArrayList<Project> projects;
    public final ArrayList<Donor> donors;
    public final Admin admin;

    public System(Admin admin) {
        this.donations = new ArrayList<>();
        this.locations = new ArrayList<>();
        this.projects  = new ArrayList<>();
        this.donors    = new ArrayList<>();
        this.admin     = admin;
    }

    public void addDonation(Donation donation) { donations.add(donation); }

    public void addLocation(Location location) { locations.add(location); }

    public void addProject(Project project) { projects.add(project); }

    public void addDonor(Donor donor) { donors.add(donor); }

    public Admin getAdmin() { return admin; }

	public Integer accumulatedPoints(Donor aDonor) {
		List<Donation> donationsDonor = donationOfDonor(aDonor);
		return totalDonationsMoth(donationsDonor) + totalPointsDonations(donationsDonor);
	}

	private int totalPointsDonations(List<Donation> donationsDonor) {
		return donationsDonor.stream()
				.mapToInt((donation) -> donation.getPoints())
				.sum();
	}

	private int totalDonationsMoth(List<Donation> donationsDonor) {
		int totalDonationsMoth = (int) donationsDonor.stream()
				.filter((donation) -> donation.getDate().getMonth() == LocalDate.now().getMonth())
				.count();
		return totalDonationsMoth >= 2 ? 500 : 0;
	}
	
	private List<Donation> donationOfDonor(Donor aDonor) {
		return donations.stream()
				.filter((donation) -> donation.getNickname() == aDonor.getNickname())
				.collect(Collectors.toList());
	}

	public void donate(Donor aDonor, Project project, Integer amount, String comment) {
		Donation newDonation = aDonor.donate(project, amount, aDonor.getNickname(), comment);
		addDonation(newDonation);
	}
	
}
