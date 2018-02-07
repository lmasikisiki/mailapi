package com.leetech.apis.mailapi.mail

class SendMailCommand(val subject: String, val messageBody: String, val recipient: String)
class MailSentEvent(val subject: String, val recipient: String);