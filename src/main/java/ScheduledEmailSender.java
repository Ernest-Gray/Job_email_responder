
import java.awt.List;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ernest
 */
public class ScheduledEmailSender {
    
    private static String myEmail;
    private static String myName;
    private static String detailsPath;
    public static void main(String[] args) throws FileNotFoundException{
        
        //Get Emails
        LinkedList<Email> emails = Email.GetEmails();
        
        //Get Config Details
        SaveConfig details = SaveConfig.LoadConfiguration(detailsPath);
        myName = details.getMyName();
        myEmail = details.getMyEmail();
        
        //Send Emails
        for(Email email : emails){
        //System.out.println(LocalDate.now().compareTo(LocalDate.now().plusDays(Integer.parseInt(this.daysUntilSendField.getValue().toString()))) == 0);
            if (LocalDate.now() == email.dayToSend) {
                System.out.println("Email Ready, Sending!");
                SendEmail(email, myEmail, myName);
                System.out.println("Send Email: " + email.companyName + " role of " + email.jobTitle);
            }
            else{
                System.out.println("Email Too Early: " + email.companyName + " role of " + email.jobTitle + " time to send: " + email.dayToSend);
            }
            
        }
    }
    
    //Sends Email
    public static void SendEmail(Email email, String myEmail, String myName) {

        // Recipient's email ID needs to be mentioned.
        String to = email.targetEmail;

        // Sender's email ID needs to be mentioned
        String from = myEmail;

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, "Blarbaman123");  //pass your email id and password here

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
            message.setSubject(myName + " following up with the " + email.jobTitle + " position");

            // Now set the actual message
            message.setText(email.content);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
