package fr.polytech.fsback.controller;

import fr.polytech.fsback.dto.requests.AddEvaluationDto;
import fr.polytech.fsback.dto.responses.EvaluationDto;
import fr.polytech.fsback.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping("/restaurants/{restaurantId}/evaluations")
    public EvaluationDto addEvaluationToRestaurant(@Valid @PathVariable int restaurantId, @Valid @RequestBody AddEvaluationDto body) {
        return EvaluationDto.fromEntity(this.evaluationService.addEvaluationToRestaurant(restaurantId, body.getEvaluateur(), body.getCommentaire(), body.getNote()));
    }

    @DeleteMapping("/restaurants/{restaurantId}/evaluations/{evaluationId}")
    public void addEvaluationToRestaurant(@Valid @PathVariable int restaurantId, @Valid @PathVariable int evaluationId) {
        this.evaluationService.deleteEvaluation(restaurantId, evaluationId);
    }

}
