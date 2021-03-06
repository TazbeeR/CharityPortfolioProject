package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/register")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registered(@Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "register";
        }
        if (userService.findByUserName(user.getUsername()) != null){
            return "register";
        }

        if (!user.getPassword().equals(user.getPassword2())){
            String dontMatch = "Hasła muszą być identyczne";
            model.addAttribute("dontMatch", dontMatch);
            return "register";
        }

        userService.save(user);

        return "redirect:/login";
    }
}
