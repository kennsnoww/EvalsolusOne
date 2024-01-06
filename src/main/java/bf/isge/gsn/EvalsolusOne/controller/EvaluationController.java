
package bf.isge.gsn.EvalsolusOne.controller;

import bf.isge.gsn.EvalsolusOne.model.Criteria;
import bf.isge.gsn.EvalsolusOne.model.Evaluation;
import bf.isge.gsn.EvalsolusOne.service.CriteriaService;
import bf.isge.gsn.EvalsolusOne.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EvaluationController {

    private final EvaluationService evaluationService;
    private final CriteriaService criteriaService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService, CriteriaService criteriaService) {
        this.evaluationService = evaluationService;
        this.criteriaService = criteriaService;
    }

    @GetMapping("/evaluationHistory")
    public String getEvaluationHistory(Model model) {
        List<Evaluation> evaluationHistory = evaluationService.getAllEvaluations();
        model.addAttribute("evaluationHistory", evaluationHistory);
        return "evaluationHistory";
    }

    @GetMapping("/evaluate")
    public String showEvaluationForm(Model model) {
        List<Criteria> criteriaList = criteriaService.getAllCriteria();
        model.addAttribute("criteriaList", criteriaList);

        return "evaluate";
    }

    @PostMapping("/evaluate")
    public String submitEvaluation(@RequestParam("criteriaId") Long criteriaId,
                                   @RequestParam("rating") int rating,
                                   @RequestParam("comments") String comments) {
        Evaluation evaluation = new Evaluation();
        evaluation.setCriteriaId(criteriaId);
        evaluation.setRating(rating);
        evaluation.setComments(comments);

        // Soumettez l'évaluation
        evaluationService.submitEvaluation(evaluation);

        return "redirect:/evaluationHistory";
    }

}
