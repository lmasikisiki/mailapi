package com.leetech.apis.mailapi;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.spring.config.EnableAxon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.leetech.apis.mailapi.mail.SendMailCommand;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAxon
@ComponentScan(basePackages = "com.leetech.apis.mailapi.mail,com.leetech.apis.mailapi")
public class MailapiApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext c = SpringApplication.run(MailapiApplication.class, args);
		CommandBus cb = c.getBean(CommandBus.class);
		cb.dispatch(asCommandMessage(new SendMailCommand("subject", "body", "lee@leetech.com")));

	}

}
