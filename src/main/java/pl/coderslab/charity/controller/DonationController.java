package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@AllArgsConstructor
public class DonationController {

    public final DonationService donationService;
    public final CategoryService categoryService;
    public final InstitutionService institutionService;

    @ModelAttribute("categories")
    public List<Category> categories(){return categoryService.getCategories();}

    @ModelAttribute("institutions")
    public List<Institution> institutions() {return institutionService.getInstitutions();}

    @GetMapping("/donation")
    public String initForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }


    @PostMapping("/donation")
    public String saveDonation(Donation donation) {
        donationService.addDonations(donation);
        return "redirect:/";
    }

}
