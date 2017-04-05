package com.uttec.icae.service.mail;

import java.util.Map;

import org.springframework.core.io.ByteArrayResource;

public interface MailService {

	void sendMail(String message, String subject, String... recipients);

	void sendMimeMail(String message, String messageHtml, String subject,
			String... recipients);

	void sendMailWithAttach(String message, String messageHtml, String subject,
			Map<String, ByteArrayResource> attach, String... recipients);

	void sendMailWithEngine(String message, String subject, String template,
			Map<String, String> model, String... recipients);
	
}
