package ar.edu.grupoi.backend.desappbackend.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
