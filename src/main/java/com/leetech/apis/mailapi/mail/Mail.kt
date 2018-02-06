package com.leetech.apis.mailapi.mail


class SendMailCommand(val message: String, val recipient: String)
class MailSentEvent(val recipient: String);