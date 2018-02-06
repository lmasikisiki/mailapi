package com.leetech.apis.mailapi.mail;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@AggregateRoot
public class Mail {

	@AggregateIdentifier
	String mailTo;

	public Mail() {
		// TODO Auto-generated constructor stub
	}

	@CommandHandler
	public Mail(SendMailCommand command) {
		apply(new MailSentEvent(command.getRecipient()));
	}

	@EventSourcingHandler
	public void on(MailSentEvent event) {
		this.mailTo = event.getRecipient();
	}
}
