package bg.softuni.mobileleleproject.web;

import bg.softuni.mobileleleproject.model.dto.OfferCreateDTO;
import bg.softuni.mobileleleproject.model.enums.EngineEnum;
import bg.softuni.mobileleleproject.model.enums.TransmissionEnum;
import bg.softuni.mobileleleproject.service.ModelService;
import bg.softuni.mobileleleproject.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final ModelService modelService;

    @Autowired
    public OfferController(OfferService offerService, ModelService modelService) {
        this.offerService = offerService;
        this.modelService = modelService;
    }


    @GetMapping("/details/{uuid}")
    public String getOfferDetails(@PathVariable("uuid") UUID uuid,
                                  Model model) {

        model.addAttribute("offer", this.offerService.getOfferByUUID(uuid));

        return "details";
    }

    @GetMapping("/add")
    public String showAddingForm(Model model) {

        if (!model.containsAttribute("offerCreateDTO")) {
            model.addAttribute("offerCreateDTO", new OfferCreateDTO());
        }

        if (!model.containsAttribute("modelsNames")) {
            model.addAttribute("modelsNames", this.modelService.getAllModelsNames());
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
    public String addOffer() {

        return "redirect:/";
    }

}