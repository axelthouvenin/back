package fr.polytech.fsback.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEvaluationDto {

    @JsonProperty("evaluateur")
    @Size(max = 50)
    private String evaluateur;

    @JsonProperty("commentaire")
    @Size(max = 255)
    private String commentaire;

    @JsonProperty("note")
    @Min(0)
    @Max(3)
    private int note;

}
