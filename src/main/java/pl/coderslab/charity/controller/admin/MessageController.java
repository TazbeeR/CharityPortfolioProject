package pl.coderslab.charity.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.ContactMessage;
import pl.coderslab.charity.service.ContactMessageService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/message")
public class MessageController {
    private final ContactMessageService contactMessageService;

    @GetMapping("/all")
    public String initMessagePage(Model model) {
        List<ContactMessage> messageList = contactMessageService.findAll();
        model.addAttribute("messages", messageList);
        return "admin/message";
    }


}
