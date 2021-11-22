package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.ContactMessage;
import pl.coderslab.charity.entity.CurrentUser;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.ContactMessageService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

@Controller
@AllArgsConstructor
public class HomeController {
private InstitutionService institutionService;
private DonationService donationService;
private ContactMessageService contactMessageService;


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.getInstitutions());
        model.addAttribute("sumOfBags", donationService.sumOfBags());
        model.addAttribute("sumOfDonations", donationService.sumOfDonations());
        return "index";
    }

    @PostMapping("/")
    public String contactMessage(@RequestParam String name, @RequestParam String email, @RequestParam String message){
        ContactMessage newMessage = new ContactMessage(name, email, message, false);
        contactMessageService.save(newMessage);

        return "form-confirmation";
    }

    @GetMapping("/403")
    public String page403(){
        return "403";
    }

    @GetMapping("/userinfo")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

}
