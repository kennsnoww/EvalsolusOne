package bf.isge.gsn.EvalsolusOne.service;

import bf.isge.gsn.EvalsolusOne.model.Criteria;
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
        return evaluationRepository.findByCriteriaId(criteriaId);
    }

    //@Override
    //public Evaluation submitEvaluation(Evaluation evaluation) {
     //   return evaluationRepository.save(evaluation);
   // }
   /* @Override
    public Evaluation submitEvaluation(Evaluation evaluation) {
        // Vérifiez que la note est dans la plage de 0 à 5
        if (evaluation.getRating() >= 0 && evaluation.getRating() <= 5) {
            return evaluationRepository.save(evaluation);
        } else {
            // Gérez l'erreur ou renvoyez un objet d'erreur, selon vos besoins
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 5.");
        }
    }*/
    @Override
    public Evaluation submitEvaluation(Evaluation evaluation) {
        Long criteriaId = evaluation.getCriteriaId();

        // Vérifier si le critère associé à l'évaluation existe
        Criteria associatedCriteria = CriteriaService.getCriteriaById(criteriaId);
        if (associatedCriteria == null) {
            throw new IllegalArgumentException("Le critère associé à l'évaluation n'existe pas.");
        }

        // Vérifier si la note est dans la plage de 0 à 5
        int rating = evaluation.getRating();
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("La note de l'évaluation doit être comprise entre 0 et 5.");
        }

        // Enregistrer l'évaluation seulement si la validation réussit
        return evaluationRepository.save(evaluation);
    }



    @Override
    public double getAverageRating(Long criteriaId) {
        List<Evaluation> evaluations = evaluationRepository.findByCriteriaId(criteriaId);
        if (evaluations.isEmpty()) {
            return 0.0;
        }

        double sum = evaluations.stream().mapToInt(Evaluation::getRating).sum();
        return sum / evaluations.size();
    }

    // Ajoutez d'autres implémentations au besoin
}
