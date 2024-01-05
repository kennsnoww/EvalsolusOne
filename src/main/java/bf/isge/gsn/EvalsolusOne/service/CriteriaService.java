package bf.isge.gsn.EvalsolusOne.service;

import bf.isge.gsn.EvalsolusOne.model.Criteria;

import java.util.List;
import java.util.Map;

public interface CriteriaService {
    List<Criteria> getAllCriteria();
    Criteria createCriteria(Criteria criteria);
    Map<Criteria, Double> getAverageRatings();

}
