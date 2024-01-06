package bf.isge.gsn.EvalsolusOne.controller;

import bf.isge.gsn.EvalsolusOne.model.Evaluation;
import bf.isge.gsn.EvalsolusOne.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class EvaluationRestController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping
    public ResponseEntity<List<Evaluation>> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationService.getAllEvaluations();
        return new ResponseEntity<>(evaluations, HttpStatus.OK);
    }

    @GetMapping("/criteria/{criteriaId}")
    public ResponseEntity<List<Evaluation>> getEvaluationsByCriteria(@PathVariable Long criteriaId) {
        List<Evaluation> evaluations = evaluationService.getEvaluationsByCriteria(criteriaId);
        return new ResponseEntity<>(evaluations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evaluation> submitEvaluation(@RequestBody Evaluation evaluation) {
        Evaluation savedEvaluation = evaluationService.submitEvaluation(evaluation);
        return new ResponseEntity<>(savedEvaluation, HttpStatus.CREATED);
    }

    @GetMapping("/average/{criteriaId}")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long criteriaId) {
        double averageRating = evaluationService.getAverageRating(criteriaId);
        return new ResponseEntity<>(averageRating, HttpStatus.OK);
    }

    @PutMapping("/{evaluationId}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable Long evaluationId, @RequestBody Evaluation evaluation) {
        // Implémentez la logique de mise à jour ici
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{evaluationId}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long evaluationId) {
        // Implémentez la logique de suppression ici
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
