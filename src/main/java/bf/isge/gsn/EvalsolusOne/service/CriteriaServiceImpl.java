package bf.isge.gsn.EvalsolusOne.service;

import bf.isge.gsn.EvalsolusOne.model.Criteria;
import bf.isge.gsn.EvalsolusOne.model.Evaluation;
import bf.isge.gsn.EvalsolusOne.repository.CriteriaRepository;
import bf.isge.gsn.EvalsolusOne.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CriteriaServiceImpl implements CriteriaService {

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public List<Criteria> getAllCriteria() {
        return criteriaRepository.findAll();
    }

    @Override
    public Criteria createCriteria(Criteria criteria) {
        return criteriaRepository.save(criteria);
    }

    @Override
    public Map<Criteria, Double> getAverageRatings() {
        Map<Criteria, Double> averageRatings = new HashMap<>();

        List<Criteria> allCriteria = criteriaRepository.findAll();
        for (Criteria criteria : allCriteria) {
            List<Evaluation> evaluations = evaluationRepository.findByCriteriaId(criteria.getId());

            if (evaluations.isEmpty()) {
                averageRatings.put(criteria, 0.0);
            } else {
                double totalRating = evaluations.stream().mapToInt(Evaluation::getRating).sum();
                double averageRating = totalRating / evaluations.size();
                averageRatings.put(criteria, averageRating);
            }
        }

        return averageRatings;
    }

}
