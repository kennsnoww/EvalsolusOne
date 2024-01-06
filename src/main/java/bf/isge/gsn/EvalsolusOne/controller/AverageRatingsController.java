package bf.isge.gsn.EvalsolusOne.controller;

import bf.isge.gsn.EvalsolusOne.model.Criteria;
import bf.isge.gsn.EvalsolusOne.model.Evaluation;
import bf.isge.gsn.EvalsolusOne.service.CriteriaService;
import bf.isge.gsn.EvalsolusOne.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller

public class AverageRatingsController {

    private final EvaluationService evaluationService;
    private final CriteriaService criteriaService;

    @Autowired
    public AverageRatingsController(EvaluationService evaluationService, CriteriaService criteriaService) {
        this.evaluationService = evaluationService;
        this.criteriaService = criteriaService;
    }

    @GetMapping("/averageRatings")
    public String getAverageRatings(Model model) {
        List<Criteria> allCriteria = criteriaService.getAllCriteria();
        Map<Criteria, Double> averageRatings = new HashMap<>();

        for (Criteria criteria : allCriteria) {
            List<Evaluation> evaluations = evaluationService.getEvaluationsByCriteria(criteria.getId());
            double average = calculateAverageRating(evaluations);
            averageRatings.put(criteria, average);
        }

        model.addAttribute("averageRatings", averageRatings);
        return "averageRatings";
    }

    private double calculateAverageRating(List<Evaluation> evaluations) {
        if (evaluations == null || evaluations.isEmpty()) {
            return 0.0;
        }

        int sum = evaluations.stream().mapToInt(Evaluation::getRating).sum();
        return (double) sum / evaluations.size();
    }



}

