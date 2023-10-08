package bg.softuni.mobileleleproject.web;

import bg.softuni.mobileleleproject.model.dto.UserRegistrationDTO;
import bg.softuni.mobileleleproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String registration(@Valid UserRegistrationDTO userRegistrationDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.userService.registerUser(userRegistrationDTO)) {
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);

            return ("/auth-register");
        }

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