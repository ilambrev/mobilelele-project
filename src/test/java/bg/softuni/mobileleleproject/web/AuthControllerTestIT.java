package bg.softuni.mobileleleproject.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

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
                .andDo(print());
    }
}