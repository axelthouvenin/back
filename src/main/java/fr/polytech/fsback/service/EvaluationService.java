package fr.polytech.fsback.service;

import fr.polytech.fsback.entity.EvaluationEntity;
import fr.polytech.fsback.entity.RestaurantEntity;
import fr.polytech.fsback.exception.InvalidValueException;
import fr.polytech.fsback.exception.ResourceDoesntExistException;
import fr.polytech.fsback.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final RestaurantService restaurantService;

    public EvaluationEntity getEvaluationById(int evaluationId){
        return this.evaluationRepository.findById(evaluationId)
                .orElseThrow(() -> new ResourceDoesntExistException("The evaluation with id " + evaluationId + " does not exist"));
    }

    public EvaluationEntity addEvaluationToRestaurant(int restaurantId, final String evaluateur, final String commentaire, int note) {
        if (note < 0 || note > 3) {
            throw new InvalidValueException("The note must be between 0 and 3");
        }

        if (evaluateur == null || evaluateur.isBlank()) {
            throw new InvalidValueException("l'evaluateur ne doit pas être vide");
        }

        if (commentaire == null || commentaire.isBlank()) {
            throw new InvalidValueException("le commentaire ne doit pas être vide");
        }

        RestaurantEntity restaurant = this.restaurantService.getRestaurantById(restaurantId);

        EvaluationEntity nouvelleEvaluation = EvaluationEntity.builder()
                .evaluateur(evaluateur)
                .commentaire(commentaire)
                .note(note)
                .restaurant(restaurant)
                .build();

        return this.evaluationRepository.save(nouvelleEvaluation);
    }

    public void deleteEvaluation(int restaurantId, int evaluationId) {
        this.restaurantService.getRestaurantById(restaurantId);

        EvaluationEntity entity = this.getEvaluationById(evaluationId);
        this.evaluationRepository.delete(entity);
    }

}
