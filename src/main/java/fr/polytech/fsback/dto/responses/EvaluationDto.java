package fr.polytech.fsback.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.fsback.entity.EvaluationEntity;
import lombok.*;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("evaluateur")
    private String evaluateur;

    @JsonProperty("commentaire")
    private String commentaire;

    @JsonProperty("note")
    private int note;

    public static EvaluationDto fromEntity(final EvaluationEntity entity) {
        return EvaluationDto.builder()
                .id(entity.getId())
                .evaluateur(entity.getEvaluateur())
                .commentaire(entity.getCommentaire())
                .note(entity.getNote())
                .build();
    }

}
