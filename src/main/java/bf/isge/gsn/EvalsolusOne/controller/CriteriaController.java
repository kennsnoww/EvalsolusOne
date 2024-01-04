// CriteriaController.java
package bf.isge.gsn.EvalsolusOne.controller;

import bf.isge.gsn.EvalsolusOne.model.Criteria;
import bf.isge.gsn.EvalsolusOne.service.CriteriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CriteriaController {

    private final CriteriaService criteriaService;

    public CriteriaController(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }
    @GetMapping("/criteriaList")
    public String getCriteriaList(Model model) {
        List<Criteria> criteriaList = criteriaService.getAllCriteria();
        model.addAttribute("criteriaList", criteriaList);
        return "criteriaList";
    }
    @GetMapping("/addCriteria")
    public String showAddCriteriaForm() {
        return "addCriteria";
    }

    @PostMapping("/addCriteria")
    public String addCriteria(Criteria criteria) {
        criteriaService.createCriteria(criteria);
        return "redirect:/criteriaList";
    }

    // Ajoutez d'autres méthodes au besoin
}
