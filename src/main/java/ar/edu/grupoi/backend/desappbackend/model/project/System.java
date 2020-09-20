package ar.edu.grupoi.backend.desappbackend.model.project;

import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

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

}
