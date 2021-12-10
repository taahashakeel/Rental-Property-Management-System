import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

package BackEnd;

@SuppressWarnings("unused")
public class EmailSystem {

	public static boolean sendEmail(String to, String sender, String body, String header) {
		
	// Get system properties
      Properties properties = new Properties();
      
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable","true");
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      
      String from = "ensf480testing1@gmail.com";
      String password = "ensf480ensf480";
      
      Session session = Session.getInstance(properties,new Authenticator(){
    	  protected PasswordAuthentication getPasswordAuthentication() {
    		  return new PasswordAuthentication(from,password);
    	  }
      });
	      
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(sender));
			message.setSubject(header);
			message.setText(body);
			Transport.send(message);
			return true;
		}catch(MessagingException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
/*	public static void main(String[]args) {
		//EmailSystem email = new EmailSystem("hoodie.the.mage@gmail.com","angrybacca@gmail.com");
		//email.sendEmail("Welcome to the body.","This is a header.");
		EmailSystem.sendEmail("angrybacca@gmail.com","hoodie.the.mage@gmail.com","This is the body","this is the header");
		System.out.println("Program Done");
		
	}
	
	*/
	

}
