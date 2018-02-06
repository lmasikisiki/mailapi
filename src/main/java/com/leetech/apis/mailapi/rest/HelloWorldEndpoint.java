package com.leetech.apis.mailapi.rest;

import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	@Path("/world")
	public Response doGet() {
		final String username = "mfuzo123@gmail.com";
		final String password = "mfuzo830327";

		// setting gmail smtp properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// check the authentication
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			System.out.println("trying to send");

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mfuzo123@gmail.com"));

			// recipients email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("masikisiki@gmail.com"));
			System.out.println("all set");

			// add the Subject of email
			message.setSubject("JavaMail API Test");

			// message body
			message.setText("This is a test mail only");// message

			Transport.send(message);

			System.out.println("Email Sent Successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);

		}
		return Response.ok("Hello from WildFly Swarm!").build();
	}
}