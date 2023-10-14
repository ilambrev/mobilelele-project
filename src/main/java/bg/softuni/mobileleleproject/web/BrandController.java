package bg.softuni.mobileleleproject.web;

import bg.softuni.mobileleleproject.model.dto.BrandDTO;
import bg.softuni.mobileleleproject.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @ModelAttribute("brands")
    public List<BrandDTO> brands() {

        return this.brandService.getAllBrands();
    }

    @GetMapping("/all")
    public String getAll() {

        return "/brands";
    }

}