package Mail;

import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;

import java.io.File;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) {

  
        final String senderEmail = "test.auto.avidea@gmail.com";
        final String appPassword = "dehzkysdolkycdhl"; 
        final String[] recipientEmails = {
    
            "amentebib28@gmail.com"
        };

        // SMTP Server Properties
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587");

        // Create session with Authentication
        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, appPassword);
            }
        });

        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            
            // Ajouter plusieurs destinataires
            InternetAddress[] addresses = new InternetAddress[recipientEmails.length];
            for (int i = 0; i < recipientEmails.length; i++) {
                addresses[i] = new InternetAddress(recipientEmails[i]);
            }
            message.setRecipients(Message.RecipientType.TO, addresses);

            message.setSubject("Test Email from QA automation");

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Hello,\n\nPlease find the attached automation test report.");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = System.getProperty("user.dir") + "/target/cucumber-report.html";
            System.out.println("Attachment path is: " + filePath);
            attachmentPart.attachFile(new File(filePath));

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("✅ Email sent successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}