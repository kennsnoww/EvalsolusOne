package bf.isge.gsn.EvalsolusOne.service;

import bf.isge.gsn.EvalsolusOne.model.Evaluation;
import bf.isge.gsn.EvalsolusOne.model.Criteria;

import java.util.List;
public interface EvaluationService {
    List<Evaluation> getAllEvaluations();
    List<Evaluation> getEvaluationsByCriteria(Long criteriaId);
    Evaluation submitEvaluation(Evaluation evaluation);
    double getAverageRating(Long criteriaId);
    // Ajoutez d'autres méthodes au besoin
}



