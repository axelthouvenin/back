package fr.polytech.fsback.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRestaurantDto {

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("adresse")
    private String adresse;

}
