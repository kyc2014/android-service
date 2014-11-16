package com.abroad.studies.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import com.abroad.studies.model.User;

public class MailSender {
	private static final String username = "graduatestudiesevaluator@gmail.com";
	private static final String password = "Arigatou#1";
	private static final String baseURL="/user/activate/";
	public static void Send(User user){
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,
	  new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("graduatestudiesevaluator@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(user.getEmail()));
		message.setSubject("Graduate Studies Profile Activation");
		message.setText("Dear "+user.getName()+","
			+ "\n\n Thanks for choosing our profile evaluation, please click the following link to " +
			"activate your profile!\n\n"+baseURL+"/"+user.getActId()+"\n\n" +
					"Regards,\nAdmin");

		Transport.send(message);

		System.out.println("Done");

	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}
	}
}
