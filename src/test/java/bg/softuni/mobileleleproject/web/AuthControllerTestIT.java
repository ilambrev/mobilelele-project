package bg.softuni.mobileleleproject.web;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Value("${mobilelele.mail.port}")
    private int port;

    @Value("${mobilelele.mail.host}")
    private String host;

    @Value("${mobilelele.mail.username}")
    private String username;

    @Value("${mobilelele.mail.password}")
    private String password;

    private GreenMail greenMail;

    @BeforeEach
    void setUp() {
        greenMail = new GreenMail(new ServerSetup(port, host, "smtp"));
        greenMail.start();
        greenMail.setUser(username, password);
    }

    @AfterEach
    void tearDown() {
        greenMail.stop();
    }

    @Test
    void testRegistration() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/register")
                                .param("firstName", "Alice")
                                .param("lastName", "Cooper")
                                .param("email", "cooper@mobilelele.bg")
                                .param("password", "test")
                                .param("confirmPassword", "test")
                                .with(csrf())
                ).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/users/login"))
                .andDo(print());

        greenMail.waitForIncomingEmail(1);

        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        Assertions.assertEquals(1, receivedMessages.length);

        MimeMessage registrationMessage = receivedMessages[0];
        Assertions.assertTrue(registrationMessage.getContent().toString().contains("Alice"));

        Assertions.assertEquals(1, registrationMessage.getAllRecipients().length);
        Assertions.assertEquals("cooper@mobilelele.bg", registrationMessage.getAllRecipients()[0].toString());
    }
}