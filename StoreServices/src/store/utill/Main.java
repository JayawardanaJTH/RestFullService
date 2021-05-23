package store.utill;

import java.util.ArrayList;
import java.util.Properties;

//import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;
import store.model.Item;
import store.model.User;

public class Main {
	// Find your Account Sid and Token at twilio.com/console
	public static final String ACCOUNT_SID = "ACd72fb73389057fb4b8934e5c770f9f44";
	public static final String AUTH_TOKEN = "27e0d1b5e988ba5066cc2615aabec2ec";

	public static void main(String[] args) {
		IDatabase db = new DatabaseImpl();
		String num = "769036197";
//		db.saveData(Constant.USER_TYPE_ROOT, new User("Harsha","tiran2323","asdf","Seller", 1234));
//		db.saveData(Constant.ITEM_TYPE_ROOT, new Item("item2", "this is 2", 300.50));

//		ArrayList<User> list = db.getAllData(Constant.USER_TYPE_ROOT);
//		ArrayList<Item> items = db.getAllData(Constant.ITEM_TYPE_ROOT);
//		
//		for(Item item : items) {
//			
//			System.out.println(item.getName());
//		}
		
//		Item item = db.getItem(2);
		
//		User user = db.getUser("Tiran", "12345");
		
//		System.out.println(user.getUserName());
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("+94"+num),  
                "MG87b2ebde5183a5fc59a3f4ab480e2114", 
                "Dear coustomer your payment is successful Thankyou").create(); 
 
        System.out.println(message.getSid()); 
		
		/**
		 * Mail service
		 */
		
//		// Recipient's email ID needs to be mentioned.
//        String to = "tiranharsha2323@gmail.com";
//
//        // Sender's email ID needs to be mentioned
//        String from = "secraterywththala@gmail.com";
//
//        // Assuming you are sending email from through gmails smtp
//        String host = "smtp.gmail.com";
//
//        // Get system properties
//        Properties properties = System.getProperties();
//
//        // Setup mail server
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//
//        // Get the Session object.// and pass username and password
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//
//            protected PasswordAuthentication getPasswordAuthentication() {
//
//                return new PasswordAuthentication("secraterywththala@gmail.com", "Asdf1234@");
//
//            }
//        });
//        
//     // Used to debug SMTP issues
//        session.setDebug(true);
//
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            message.setSubject("This is the Subject Line!");
//
//            // Now set the actual message
//            message.setText("This is actual message");
//
//            // Send the actual HTML message.
////            message.setContent(
////                   "<h1>This is actual message embedded in HTML tags</h1>",
////                  "text/html");
//            
//            System.out.println("sending...");
//            // Send message
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }

}
}
