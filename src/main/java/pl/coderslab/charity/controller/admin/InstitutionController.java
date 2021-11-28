package pl.coderslab.charity.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/institution")
public class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping("/all")
    public String getInstitutions(Model model) {
        List<Institution> institutions = institutionService.getInstitutions();
        model.addAttribute("institutions", institutions);
        return "admin/institution";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("institution", new Institution());
        return "admin/institutioninfo";
    }

    @PostMapping("/add")
    public String addInstitution(@Valid Institution institution, BindingResult result){
        if (result.hasErrors()){
            return "admin/institutioninfo";
        }
        institutionService.save(institution);
        return "redirect:/admin/institution/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteInstitution(@PathVariable Long id) {
        Optional<Institution> institution = institutionService.findById(id);
        institutionService.remove(institution.orElseThrow(EntityNotFoundException::new));
        return "redirect:/admin/institution/all";
    }

    @GetMapping("/update/{id}")
    public String editInstitution(@PathVariable Long id, Model model) {
        Institution institution = institutionService.findById(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("institution", institution);
        return "admin/institutioninfo";
    }

    @PostMapping("/update/{id}")
    public String updateInstitution(@Valid Institution institution, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/institutioninfo";
        }
            institutionService.update(institution);
        return "redirect:/admin/institution/all";
    }
}
