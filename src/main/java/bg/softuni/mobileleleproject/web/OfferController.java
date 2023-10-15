package bg.softuni.mobileleleproject.web;

import bg.softuni.mobileleleproject.model.dto.CreateOfferDTO;
import bg.softuni.mobileleleproject.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/details/{uuid}")
    public String getOfferDetails(@PathVariable("uuid") UUID uuid,
                                  Model model) {

        model.addAttribute("offer", this.offerService.getOfferByUUID(uuid));

        return "details";
    }

    @GetMapping("/add")
    public String showAddingForm(Model model) {

        if (!model.containsAttribute("createOfferDTO")) {
            model.addAttribute("createOfferDTO", new CreateOfferDTO());
        }

        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer() {

        return "redirect:/";
    }

}