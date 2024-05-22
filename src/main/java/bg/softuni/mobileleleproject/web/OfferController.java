package bg.softuni.mobileleleproject.web;

import bg.softuni.mobileleleproject.model.dto.OfferCreateDTO;
import bg.softuni.mobileleleproject.model.enums.EngineEnum;
import bg.softuni.mobileleleproject.model.enums.TransmissionEnum;
import bg.softuni.mobileleleproject.service.BrandService;
import bg.softuni.mobileleleproject.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    @Autowired
    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }


    @GetMapping("/details/{uuid}")
    public String offerDetails(@PathVariable("uuid") UUID uuid,
                                  Model model) {

        model.addAttribute("offer", this.offerService.getOfferByUUID(uuid));

        return "details";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        if (!model.containsAttribute("offerCreateDTO")) {
            model.addAttribute("offerCreateDTO", new OfferCreateDTO());
        }

        if (!model.containsAttribute("brands")) {
            model.addAttribute("brands", this.brandService.getAllBrands());
        }

        if (!model.containsAttribute("engineTypes")) {
            model.addAttribute("engineTypes", EngineEnum.values());
        }

        if (!model.containsAttribute("transmissionTypes")) {
            model.addAttribute("transmissionTypes", TransmissionEnum.values());
        }

        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid OfferCreateDTO offerCreateDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails currentUser) {

        System.out.println();

        if (bindingResult.hasErrors() || !this.offerService.addOffer(offerCreateDTO, currentUser)) {
            redirectAttributes.addFlashAttribute("offerCreateDTO", offerCreateDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerCreateDTO", bindingResult);

            return "redirect:/offer/add";
        }

        return "redirect:/offers/all";
    }
}