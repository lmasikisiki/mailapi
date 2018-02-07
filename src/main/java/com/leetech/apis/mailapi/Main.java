package com.leetech.apis.mailapi;

import org.axonframework.commandhandling.AsynchronousCommandBus;
import org.axonframework.config.Configuration;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;

import com.leetech.apis.mailapi.mail.Mail;
import com.leetech.apis.mailapi.mail.SendMailCommand;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;
public class Main {

	public static void main(String[] args) {
		Configuration configuration = DefaultConfigurer.defaultConfiguration().configureAggregate(Mail.class)
				.configureEmbeddedEventStore(c -> new InMemoryEventStorageEngine())
				.configureCommandBus(c -> new AsynchronousCommandBus()).buildConfiguration();
		
		configuration.start();
		configuration.commandBus().dispatch(asCommandMessage(new SendMailCommand("subject", "body","lee@leetech.com")));
	}
}
