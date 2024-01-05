package bf.isge.gsn.EvalsolusOne.repository;

import bf.isge.gsn.EvalsolusOne.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    static List<Evaluation> findByCriteriaId(Long criteriaId) {
        return null;
    }
}