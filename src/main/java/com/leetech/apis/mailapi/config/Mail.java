package com.leetech.apis.mailapi.config;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.leetech.apis.mailapi.mail.MailSentEvent;
import com.leetech.apis.mailapi.mail.SendMailCommand;

@Aggregate
@Entity
public class Mail {

	@AggregateIdentifier
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mailId;
	String recipient;
	String subject;

	public Mail() {
	}

	@CommandHandler
	public Mail(SendMailCommand command) {
		apply(new MailSentEvent(command.getSubject(), command.getRecipient()));
	}

	@EventSourcingHandler
	@EventHandler
	public void on(MailSentEvent event) {
		this.recipient = event.getRecipient();
		this.subject = event.getSubject();
		System.out.println("An email has been sent to " + this.recipient);
	}

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
