package fr.polytech.fsback.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.fsback.entity.EvaluationEntity;
import fr.polytech.fsback.entity.RestaurantEntity;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("evaluations")
    private List<EvaluationDto> evaluations;

    @JsonProperty("moyenne")
    private double moyenne;

    public static RestaurantDto fromEntity(final RestaurantEntity entity) {
        return RestaurantDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .adresse(entity.getAdresse())
                .evaluations(entity.getEvaluations().stream().map(EvaluationDto::fromEntity).collect(Collectors.toList()))
                .moyenne(entity.getEvaluations().stream().mapToInt(EvaluationEntity::getNote).average().orElse(-1))
                .build();
    }

}
