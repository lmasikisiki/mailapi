package com.leetech.apis.mailapi.mail;

public class MailSentEvent {

	private String subject;
	private String recipient;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public MailSentEvent() {
		// TODO Auto-generated constructor stub
	}

	public MailSentEvent(String subject, String recipient) {
		super();
		this.subject = subject;
		this.recipient = recipient;
	}

}
