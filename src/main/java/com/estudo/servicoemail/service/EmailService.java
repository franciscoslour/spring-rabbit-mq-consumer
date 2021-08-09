package com.estudo.servicoemail.service;

import com.estudo.servicoemail.model.EmailModel;
import com.estudo.servicoemail.model.StatusEmail;
import com.estudo.servicoemail.repository.EmailModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    @Autowired
    private EmailModelRepository emailModelRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        try{

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(emailModel.getEmailFrom());
            simpleMailMessage.setTo(emailModel.getEmailTo());
            simpleMailMessage.setSubject(emailModel.getSubject());
            simpleMailMessage.setText(emailModel.getText());

            javaMailSender.send(simpleMailMessage);
            emailModel.setStatusEmail(StatusEmail.SENT);
        }catch (MailException exception){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return this.emailModelRepository.save(emailModel);
        }
    }
}
