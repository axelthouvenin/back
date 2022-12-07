package fr.polytech.fsback.service;

import fr.polytech.fsback.entity.RestaurantEntity;
import fr.polytech.fsback.exception.InvalidValueException;
import fr.polytech.fsback.exception.ResourceDoesntExistException;
import fr.polytech.fsback.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantEntity> getRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public RestaurantEntity getRestaurantById(int restaurantId) {
        return this.restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceDoesntExistException("The restaurant with id " + restaurantId + " does not exist"));
    }

    public RestaurantEntity addRestaurant(String nom, String adresse) {

        if (nom == null || nom.isBlank()) {
            throw new InvalidValueException("le nouveau nom ne doit pas être vide");
        }

        if (adresse == null || adresse.isBlank()) {
            throw new InvalidValueException("la nouvelle adresse ne doit pas être vide");
        }

        RestaurantEntity nouveauRestaurant = RestaurantEntity.builder().nom(nom).adresse(adresse).evaluations(new ArrayList<>()).build();

        return this.restaurantRepository.save(nouveauRestaurant);
    }

    public RestaurantEntity updateRestaurant(int id, String nom, String adresse) {
        if (nom == null || nom.isBlank()) {
            throw new InvalidValueException("le nouveau nom ne doit pas être vide");
        }

        if (adresse == null || adresse.isBlank()) {
            throw new InvalidValueException("la nouvelle adresse ne doit pas être vide");
        }

        RestaurantEntity restaurant = this.getRestaurantById(id);
        restaurant.setNom(nom);
        restaurant.setAdresse(adresse);

        return this.restaurantRepository.save(restaurant);
    }

}
