package bg.softuni.mobileleleproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

@GetMapping("/register")
    public String register() {

    return "/auth-register";
}


}