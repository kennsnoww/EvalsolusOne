package bf.isge.gsn.EvalsolusOne.controller;

import bf.isge.gsn.EvalsolusOne.model.Evaluation;
import bf.isge.gsn.EvalsolusOne.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EvaluationController {

    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("/evaluationHistory")
    public String getEvaluationHistory(Model model) {
        List<Evaluation> evaluationHistory = evaluationService.getAllEvaluations();
        model.addAttribute("evaluationHistory", evaluationHistory);
        return "evaluationHistory";
    }

    @GetMapping("/evaluate")
    public String showEvaluationForm() {
        return "evaluate";
    }

    @PostMapping("/evaluate")
    public String submitEvaluation(Evaluation evaluation) {
        evaluationService.submitEvaluation(evaluation);
        return "redirect:/evaluationHistory";
    }

    // Ajoutez d'autres méthodes au besoin
}
