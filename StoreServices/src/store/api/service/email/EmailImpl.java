package store.api.service.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import store.model.User;
import store.utill.Common;
import store.utill.Constant;

public class EmailImpl implements IEmail {

	@Override
	public void sendEmail(User user) {
		// Recipient's email ID needs to be mentioned.
        String to = user.getEmail();

        // Sender's email ID needs to be mentioned
        String from = Common.PROPERTIES.getProperty(Constant.PROPERTY_SENDER_EMAIL);

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, Common.PROPERTIES.getProperty(Constant.PROPERTY_SENDER_EMAIL_PASSWORD));

            }
        });
        
     // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Payment is recived");

            // Now set the actual message
//            message.setText("This is actual message");

            String messageString = "<h2>Payment is successful!</h2><ul><li>User name : "+user.getUserName()+"</li>";
            // Send the actual HTML message.
            message.setContent(messageString,"text/html");
            
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

	}

}
