package bf.isge.gsn.EvalsolusOne.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long criteriaId; // ID du critère évalué
    private int rating; // Note attribuée à l'évaluation
    private String comments;
    // Ajoutez d'autres attributs au besoin

    // Ajoutez les getters et setters
}
