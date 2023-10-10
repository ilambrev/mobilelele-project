package bg.softuni.mobileleleproject.web;

import bg.softuni.mobileleleproject.model.dto.UserLoginDTO;
import bg.softuni.mobileleleproject.model.dto.UserRegistrationDTO;
import bg.softuni.mobileleleproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String showRegistrationForm(Model model) {

        if (!model.containsAttribute("userRegistrationDTO")) {
            model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
        }

        return "auth-register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid UserRegistrationDTO userRegistrationDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.userService.registerUser(userRegistrationDTO)) {
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);

            return ("redirect:/users/register");
        }

        return "redirect:/users/login";
    }

    @ModelAttribute("badCredentials")
    public boolean initBadCredentials() {

        return false;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {

        if (!model.containsAttribute("userLoginDTO")) {
            model.addAttribute("userLoginDTO", new UserLoginDTO());
        }

        return "/auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO,
                        RedirectAttributes redirectAttributes) {

        if (!this.userService.loginUser(userLoginDTO)) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/users/login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        this.userService.logOutUser();
        
        return "index";
    }

}