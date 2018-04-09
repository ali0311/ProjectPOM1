package com.hstm.assignment.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class SendMailReport {
	
	@AfterSuite
	@Test
	public void sendMailReport(){

	    EmailAttachment attachmentLogs = new EmailAttachment();
	    attachmentLogs.setPath("C:/Users/M1032759/git/ProjectPOM1/HstmAssignmentFramework/test-output/ExtentReport.html");
	    attachmentLogs.setDisposition(EmailAttachment.ATTACHMENT);
	    attachmentLogs.setDescription("Execution Report");
	    attachmentLogs.setName("Automated Suite Report");

	    try {
	        MultiPartEmail email = new MultiPartEmail();
	        //email.setDebug(debug);
	        email.setHostName("smtp.gmail.com");
	        email.addTo("Md.khan@mindtree.com");
	        email.setFrom("testali031993@gmail.com", "Me");
	        email.setAuthentication("testali031993@gmail.com","Mind@123");
	        email.setSubject("Automated Script Report");
	        email.setMsg("Hi Ali,\n"+"Please refer to attached Execution Report.\n\n"+"Thanks!\n\n\n"+"This is Automated generated mail, please don't reply.");
	        email.setSSL(true);
	        email.attach(attachmentLogs);
	        email.send();
	    } catch (EmailException e) {
	        System.out.println(e.getMessage());
	    }
	  System.out.println("Attachment sends");
		
	}
}
