package ar.edu.grupoi.backend.desappbackend.model.project;

import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
		ArrayList<Donation> donationsDonor = donationOfDonor(aDonor);
		return totalDonationsMoth(donationsDonor) + totalPointsDonations(donationsDonor);
	}

	private int totalPointsDonations(ArrayList<Donation> donationsDonor) {
		return donationsDonor.stream()
				.mapToInt(donation -> donation.getPoints())
				.sum();
	}

	private int totalDonationsMoth(ArrayList<Donation> donationsDonor) {
		int totalDonationsMoth = (int) donationsDonor.stream()
				.filter(donation -> donation.getDate().getMonth() == LocalDate.now().getMonth())
				.count();
		return totalDonationsMoth >= 2 ? 500 : 0;
	}
	
	private ArrayList<Donation> donationOfDonor(Donor aDonor) {
		return donations.stream()
				.filter(donation -> donation.getNickname() == aDonor.getNickname())
				.collect(Collectors
		        .toCollection(ArrayList::new));
	}

	public void donate(Donor aDonor, Project project, Integer amount, String comment) {
		Donation newDonation = aDonor.donate(project, amount, aDonor.getNickname(), comment);
		addDonation(newDonation);
	}

	public void finishCollection(Project project) {
		admin.finishCollection(project);
	}

	public void notiftNews(Project project) {
		ArrayList<Donor> donorsproject = findDonorsProject(project);
		admin.notifyNews(project, donorsproject);
	}

	private ArrayList<Donor> findDonorsProject(Project project) {
		ArrayList<String> nicknames = findDonorsNicknameProject(project);
		return findDonorsNickname(nicknames);
	}
	
	private ArrayList<Donor> findDonorsNickname(ArrayList<String> nicknames) {
		return nicknames.stream()
				.map(apodo -> findDonorNickname(apodo))
				.collect(Collectors
                .toCollection(ArrayList::new));
	}

	private ArrayList<String> findDonorsNicknameProject(Project project) {
		Stream<Donation> donationsProject = findDonationProject(project.getName());
		return getNicknamesDonations(donationsProject);
	}

	private ArrayList<String> getNicknamesDonations(Stream<Donation> donationsProject) {
		return donationsProject.map(donation -> donation.getNickname())
				.collect(Collectors
                .toCollection(ArrayList::new));
	}

	private  Stream<Donation> findDonationProject(String name) {
		return donations.stream()
				.filter(donation -> donation.getNickname() == name);
	}

	private Donor findDonorNickname(String apodo) {
		return donors.stream()
				.filter(donor -> donor.getNickname() == apodo)
				.collect(Collectors.toList()).get(0);
	}

}
