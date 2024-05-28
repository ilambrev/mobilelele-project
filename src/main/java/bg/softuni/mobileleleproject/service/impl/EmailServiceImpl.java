package bg.softuni.mobileleleproject.service.impl;

import bg.softuni.mobileleleproject.config.MailConfiguration;
import bg.softuni.mobileleleproject.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {

    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;
    private final MailConfiguration mailConfiguration;

    public EmailServiceImpl(TemplateEngine templateEngine, JavaMailSender javaMailSender, MailConfiguration mailConfiguration) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
        this.mailConfiguration = mailConfiguration;
    }

    @Override
    public void sendRegistrationEmail(String userEmail, String userName) {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setFrom(this.mailConfiguration.getMobileleleMail());
            mimeMessageHelper.setReplyTo(this.mailConfiguration.getMobileleleMail());
            mimeMessageHelper.setSubject("Welcome to Mobilelele!");
            mimeMessageHelper.setText(generateRegistrationEmailBody(userName), true);

            this.javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            throw new RuntimeException();
        }
    }

    private String generateRegistrationEmailBody(String userName) {
        Context context = new Context();

        context.setVariable("username", userName);

        return this.templateEngine.process("email/registration-email", context);
    }
}