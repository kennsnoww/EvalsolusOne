/*
package bf.isge.gsn.EvalsolusOne.service;

import bf.isge.gsn.EvalsolusOne.model.Evaluation;
import bf.isge.gsn.EvalsolusOne.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public List<Evaluation> getEvaluationsByCriteria(Long criteriaId) {
        return EvaluationRepository.findByCriteriaId(criteriaId);
    }
    @Override
    public Evaluation submitEvaluation(Evaluation evaluation) {
        // Vérifiez que la note est dans la plage de 0 à 5
        if (evaluation.getRating() >= 0 && evaluation.getRating() <= 5) {
            return evaluationRepository.save(evaluation);
        } else {
            // Gérez l'erreur ou renvoyez un objet d'erreur
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 5.");
        }
    }

    @Override
    public double getAverageRating(Long criteriaId) {
        List<Evaluation> evaluations = EvaluationRepository.findByCriteriaId(criteriaId);
        if (evaluations.isEmpty()) {
            return 0.0;
        }
        double sum = evaluations.stream().mapToInt(Evaluation::getRating).sum();
        return sum / evaluations.size();
    }
}
*/


package bf.isge.gsn.EvalsolusOne.service;

import bf.isge.gsn.EvalsolusOne.model.Evaluation;
import bf.isge.gsn.EvalsolusOne.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public List<Evaluation> getEvaluationsByCriteria(Long criteriaId) {
        return evaluationRepository.findByCriteriaId(criteriaId); // Correction ici
    }

    @Override
    public Evaluation submitEvaluation(Evaluation evaluation) {
        // Vérifiez que la note est dans la plage de 0 à 5
        if (evaluation.getRating() >= 0 && evaluation.getRating() <= 5) {
            return evaluationRepository.save(evaluation);
        } else {
            // Gérez l'erreur ou renvoyez un objet d'erreur
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 5.");
        }
    }

    @Override
    public double getAverageRating(Long criteriaId) {
        List<Evaluation> evaluations = evaluationRepository.findByCriteriaId(criteriaId); // Correction ici
        if (evaluations.isEmpty()) {
            return 0.0;
        }
        double sum = evaluations.stream().mapToInt(Evaluation::getRating).sum();
        return sum / evaluations.size();
    }
}

