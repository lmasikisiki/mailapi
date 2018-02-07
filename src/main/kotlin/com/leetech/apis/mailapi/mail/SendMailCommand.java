package com.leetech.apis.mailapi.mail;

public class SendMailCommand {
	private String subject;
	private String messageBody;
	private String recipient;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public SendMailCommand(String subject, String messageBody, String recipient) {
		super();
		this.subject = subject;
		this.messageBody = messageBody;
		this.recipient = recipient;
	}

}
