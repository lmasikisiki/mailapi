package com.leetech.apis.mailapi.config;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventhandling.saga.repository.SagaStore;
import org.axonframework.eventhandling.saga.repository.inmemory.InMemorySagaStore;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

	@Bean
	public EventStore eventStore() {
		return new EmbeddedEventStore(new InMemoryEventStorageEngine());
	}

	@Bean
	public SagaStore<Object> sagaRepository() {
		return new InMemorySagaStore();
	}

	@Bean
	public CommandBus commandBus() {
		return new SimpleCommandBus();
	}

	@Bean
	public CommandGateway CommandGateway(CommandBus commandBus) {
		return new DefaultCommandGateway(commandBus);
	}

	@Bean
	public InMemoryEventStorageEngine eventStoreEngine() {
		return new InMemoryEventStorageEngine();
	}

}