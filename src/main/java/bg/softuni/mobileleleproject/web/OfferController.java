package bg.softuni.mobileleleproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {


    @GetMapping("/all")
    public String getAll() {

        return ("/offers");
    }

    @GetMapping("/add")
    public String add() {

        return "/offer-add";
    }

}