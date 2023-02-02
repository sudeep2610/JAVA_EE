package org.fi.allcompleterestboot.services;

public interface MailService {
	
	public void sendMail(String to, String subject, String contents);

}
