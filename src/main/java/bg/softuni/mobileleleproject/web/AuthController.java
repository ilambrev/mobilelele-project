package bg.softuni.mobileleleproject.web;

import bg.softuni.mobileleleproject.model.dto.UserRegistrationDTO;
import bg.softuni.mobileleleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {

        return "/auth-register";
    }

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initUserRegistrationDTO() {

        return new UserRegistrationDTO();
    }

    @PostMapping("/register/save")
    public String registration(UserRegistrationDTO userRegistrationDTO) {

        this.userService.registerUser(userRegistrationDTO);

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login() {

        return "/auth-login";
    }

    @GetMapping("/logout")
    public String logout() {

        return "index";
    }

}