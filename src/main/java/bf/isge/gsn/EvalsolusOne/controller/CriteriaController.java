
package bf.isge.gsn.EvalsolusOne.controller;

import bf.isge.gsn.EvalsolusOne.model.Criteria;
import bf.isge.gsn.EvalsolusOne.service.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
/*
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

}
*/

@Controller
public class CriteriaController {

    private final CriteriaService criteriaService;

    @Autowired
    public CriteriaController(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @GetMapping("/criteriaList")
    public String getCriteriaList(Model model) {
        List<Criteria> criteriaList = criteriaService.getAllCriteria();
        model.addAttribute("criteriaList", criteriaList);
        return "criteriaList";
    }


    @PostMapping("/addCriteria")
    public String addCriteria(@ModelAttribute Criteria criteria) {
        criteriaService.createCriteria(criteria);
        return "redirect:/criteriaList";
    }

    @GetMapping("/averageRatings")
    public String showAverageRatings(Model model) {
        Map<Criteria, Double> averageRatings = criteriaService.getAverageRatings();
        model.addAttribute("averageRatings", averageRatings);
        return "averageRatings";
    }

}

