package bg.softuni.mobileleleproject.web;

import bg.softuni.mobileleleproject.model.dto.OfferCreateDTO;
import bg.softuni.mobileleleproject.model.dto.OfferEditDTO;
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
import org.springframework.web.bind.annotation.*;
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

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("brands", this.brandService.getAllBrands());
        model.addAttribute("engineTypes", EngineEnum.values());
        model.addAttribute("transmissionTypes", TransmissionEnum.values());
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        if (!model.containsAttribute("offerCreateDTO")) {
            model.addAttribute("offerCreateDTO", new OfferCreateDTO());
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

    @GetMapping("/details/{uuid}")
    public String offerDetails(@PathVariable("uuid") UUID uuid, Model model) {
        model.addAttribute("offer", this.offerService.getOfferDTOByUUID(uuid));

        return "details";
    }

    @GetMapping("/edit/{uuid}")
    public String offerEdit(@PathVariable("uuid") UUID uuid, Model model) {
        if (!model.containsAttribute("offerEditDTO")) {
            model.addAttribute("offerEditDTO", this.offerService.getOfferEditDTOByUUID(uuid));
        }

        return "offer-edit";
    }

    @PatchMapping("/edit/{uuid}")
    public String offerEdit(@PathVariable("uuid") UUID uuid,
                            @Valid OfferEditDTO offerEditDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.offerService.editOffer(offerEditDTO)) {
            redirectAttributes.addFlashAttribute("offerEditDTO", offerEditDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerEditDTO", bindingResult);

            return "redirect:/offer/edit/{uuid}";
        }


        return "redirect:/offer/details/{uuid}";
    }
}