package com.cg.EmailAutomationAttachment;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	public void sendMailWithAttachment(String toEmail,
			                            String body,
			                            String subject,
			                            String attachment) throws MessagingException {
		
	MimeMessage mimeMessage= javaMailSender.createMimeMessage();
	MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
	 mimeMessageHelper.setFrom("pratugawande98@gmail.com");
     mimeMessageHelper.setTo(toEmail);
     mimeMessageHelper.setText(body);
     mimeMessageHelper.setSubject(subject);
  FileSystemResource fileSystemResource= new FileSystemResource(new File(attachment));
  mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
javaMailSender.send(mimeMessage);
System.out.println("Mail with attachment sent successfully ");
	
	}

}
