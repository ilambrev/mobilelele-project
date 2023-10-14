package bg.softuni.mobileleleproject.web;

import bg.softuni.mobileleleproject.model.dto.CreateOfferDTO;
import bg.softuni.mobileleleproject.service.BrandService;
import bg.softuni.mobileleleproject.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;
    private final BrandService brandService;

    @Autowired
    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String getAll(Model model) {

        model.addAttribute("offers", this.offerService.getAllOffers());

        return ("offers");
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