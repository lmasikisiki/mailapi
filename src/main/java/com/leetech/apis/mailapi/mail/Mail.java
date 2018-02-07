package com.leetech.apis.mailapi.mail;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
@Aggregate
public class Mail {

	@AggregateIdentifier
	String recipient;
	String subject;

	public Mail() {
	}

	@CommandHandler
	public Mail(SendMailCommand command) {
		apply(new MailSentEvent(command.getSubject(), command.getRecipient()));
	}

	@EventSourcingHandler
	public void on(MailSentEvent event) {
		this.recipient = event.getRecipient();
		this.subject = event.getSubject();
		System.out.println("An email has been sent to " + this.recipient);
	}
}
