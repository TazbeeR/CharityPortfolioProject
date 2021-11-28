package pl.coderslab.charity.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.ContactMessage;
import pl.coderslab.charity.service.ContactMessageService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/read/{id}")
    public String readMessage(@PathVariable Long id, Model model){

        ContactMessage contactMessage = contactMessageService.findById(id).orElseThrow(EntityNotFoundException::new);
        contactMessage.setReaded(true);
        model.addAttribute("message", contactMessage);
        contactMessageService.save(contactMessage);
        return "admin/messageinfo";
    }

    @GetMapping("/delete/{id}")
    public String deleteMessage(@PathVariable Long id){
        Optional<ContactMessage> contactMessage = contactMessageService.findById(id);
        contactMessageService.remove(contactMessage.orElseThrow(EntityNotFoundException::new));
        return "redirect:/admin/message/all";
    }
}
