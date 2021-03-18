package com.example.email;
import java.util.Properties;

 

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

 


public class EmailUtil {
    public  void sendEmail(String to, String msg) throws AddressException, MessagingException {
        
 
        
         Properties props = new Properties();
         
         props.put("mail.smtp.host", "172.27.172.202");
         props.put("mail.from","dadaramj@evolvingsols.com");
         props.put("mail.smtp.ssl.trust", "172.27.172.202");
         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "25");

 

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dadaramj@evolvingsols.com", "Tiger@321");
            }
        });

 

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("dadaramj@evolvingsols.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
        message.setSubject("Test email");
        message.setText(msg);
        
        Transport.send(message);
        System.out.println("Sent message successfully....");
    }
}