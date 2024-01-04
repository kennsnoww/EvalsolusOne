package bf.isge.gsn.EvalsolusOne.service;

import bf.isge.gsn.EvalsolusOne.model.Criteria;

import java.util.List;

public interface CriteriaService {
    static Criteria getCriteriaById(Long criteriaId) {
        return null;
    }

    List<Criteria> getAllCriteria();
    Criteria createCriteria(Criteria criteria);
    // Ajoutez d'autres méthodes au besoin
}
