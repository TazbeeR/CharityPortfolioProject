package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.DonationService;

@Controller
@AllArgsConstructor
public class DonationController {

    public final DonationService donationService;

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
