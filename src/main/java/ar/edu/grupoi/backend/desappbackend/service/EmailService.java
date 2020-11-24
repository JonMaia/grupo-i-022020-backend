package ar.edu.grupoi.backend.desappbackend.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;

@Transactional
@Service
public class EmailService {

	private final JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void notifyNews(List<Donor> donors, Project project) {
		for (Donor donor : donors) {
			sendNews(donor, project);
		}
	}

	private void sendNews(Donor donor, Project project) {
		MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mailMessage, true);
            helper.setTo(donor.getMail());
            helper.setSubject("Notify News");
            helper.setText(
                    "<html>"
                    + "<body>"
                    + "<div>"
                    + "<div> Dear " + donor.getName() + "</div>"
                    + "<div>We inform you that project: </div>"
                    + "<div><strong>"+project.getName()+ "</strong></div>"
                    + "<div> will be started. <div/>"
                    + "</div>"
                    + "<div>Thanks to your donation.</div>"
                    + "<div>The Team Admin.</div>"
                    + "</body>"
                    + "</html>", true);

            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

	public void sendTop10Projects(List<Project> projects, List<Donor> donors) {
		String projectNames = this.findProjectNames(projects);
		
		for (Donor donor : donors) {
			senTop10ADonorProject(donor, projectNames);
		}
	}
	
	private String findProjectNames(List<Project> projects) {
		String names = "";
		for (Project project : projects) {
			names += project.getName() +", ";
		}
		return names.substring(0,names.length()-2);
	}

	private void senTop10ADonorProject(Donor donor, String projectNames) {
		MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mailMessage, true);
            helper.setTo(donor.getMail());
            helper.setSubject("Tops 10 Project");
            helper.setText(
                    "<html>"
                    + "<body>"
                    + "<div>"
                    + "<div> Dear " + donor.getName() + "</div>"
                    + "<div>We inform then top 10 of donated projects: </div>"
                    + "<div><strong>"+projectNames+ "</strong></div>"
                    + "</div>"
                    + "<div>The Team Admin.</div>"
                    + "</body>"
                    + "</html>", true);

            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

	public void sendTop10Locations(List<Location> locations, List<Donor> donors) {
		String locationsNames = this.findLocationNames(locations);
		
		for (Donor donor : donors) {
			senTop10LocationsADonor(donor, locationsNames);
		}
	}

	private void senTop10LocationsADonor(Donor donor, String locationsNames) {
		MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mailMessage, true);
            helper.setTo(donor.getMail());
            helper.setSubject("Tops 10 Localidades");
            helper.setText(
                    "<html>"
                    + "<body>"
                    + "<div>"
                    + "<div> Dear " + donor.getName() + "</div>"
                    + "<div>We inform then top 10 of minus donated localities: </div>"
                    + "<div><strong>"+locationsNames+ "</strong></div>"
                    + "</div>"
                    + "<div>The Team Admin.</div>"
                    + "</body>"
                    + "</html>", true);

            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

	private String findLocationNames(List<Location> locations) {
		String names = "";
		for (Location location: locations) {
			names += location.getName() +", ";
		}
		return names.substring(0,names.length()-2);
	}

}
