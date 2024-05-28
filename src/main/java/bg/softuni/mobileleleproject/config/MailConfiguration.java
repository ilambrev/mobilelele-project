package bg.softuni.mobileleleproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "mobilelele.mail")
public class MailConfiguration {

    private String host;
    private int port;
    private String username;
    private String password;
    private String mobileleleMail;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setDefaultEncoding("UTF-8");
        javaMailSender.setJavaMailProperties(mailProperties());

        return javaMailSender;
    }

    private Properties mailProperties() {
        Properties properties = new Properties();

        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");

        return properties;
    }

    public String getHost() {
        return host;
    }

    public MailConfiguration setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public MailConfiguration setPort(int port) {
        this.port = port;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public MailConfiguration setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MailConfiguration setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMobileleleMail() {
        return mobileleleMail;
    }

    public MailConfiguration setMobileleleMail(String mobileleleMail) {
        this.mobileleleMail = mobileleleMail;
        return this;
    }
}