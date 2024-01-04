package bf.isge.gsn.EvalsolusOne.service;

import bf.isge.gsn.EvalsolusOne.model.Criteria;
import bf.isge.gsn.EvalsolusOne.repository.CriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaServiceImpl implements CriteriaService {

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Override
    public List<Criteria> getAllCriteria() {
        return criteriaRepository.findAll();
    }

    @Override
    public Criteria createCriteria(Criteria criteria) {
        return criteriaRepository.save(criteria);
    }

    // Ajoutez d'autres implémentations au besoin
}
