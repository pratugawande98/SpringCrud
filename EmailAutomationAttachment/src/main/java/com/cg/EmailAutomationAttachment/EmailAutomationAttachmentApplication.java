package com.cg.EmailAutomationAttachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
@EnableAutoConfiguration
public class EmailAutomationAttachmentApplication {
@Autowired
private EmailSenderService emailSenderService;
	public static void main(String[] args) {
		SpringApplication.run(EmailAutomationAttachmentApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException{
	emailSenderService.sendMailWithAttachment("pratugawande98@gmail.com",
			                                "This is email body.",
			                                "This email subject", ""+
			                                "C:\\ea\\PractionerLevel.pdf")
			                                ;
	
	}

}
