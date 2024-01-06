package bf.isge.gsn.EvalsolusOne.controller;

import bf.isge.gsn.EvalsolusOne.model.Criteria;
import bf.isge.gsn.EvalsolusOne.service.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/criteria")
public class CriteriaRestController {

    @Autowired
    private CriteriaService criteriaService;

    @GetMapping
    public ResponseEntity<List<Criteria>> getAllCriteria() {
        List<Criteria> criteriaList = criteriaService.getAllCriteria();
        return new ResponseEntity<>(criteriaList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Criteria> createCriteria(@RequestBody Criteria criteria) {
        Criteria createdCriteria = criteriaService.createCriteria(criteria);
        return new ResponseEntity<>(createdCriteria, HttpStatus.CREATED);
    }

    @PutMapping("/{criteriaId}")
    public ResponseEntity<Criteria> updateCriteria(@PathVariable Long criteriaId, @RequestBody Criteria criteria) {
        // Implémentez la logique de mise à jour ici
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{criteriaId}")
    public ResponseEntity<Void> deleteCriteria(@PathVariable Long criteriaId) {
        // Implémentez la logique de suppression ici
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/average-ratings")
    public ResponseEntity<Map<Criteria, Double>> getAverageRatings() {
        Map<Criteria, Double> averageRatings = criteriaService.getAverageRatings();
        return new ResponseEntity<>(averageRatings, HttpStatus.OK);
    }
}
