package fr.polytech.fsback.controller;

import fr.polytech.fsback.dto.requests.AddRestaurantDto;
import fr.polytech.fsback.dto.requests.UpdateRestaurantDto;
import fr.polytech.fsback.dto.responses.RestaurantDto;
import fr.polytech.fsback.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public @ResponseBody List<RestaurantDto> getRestaurants() {
        return this.restaurantService.getRestaurants().stream().map(RestaurantDto::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/restaurants/{restaurantId}")
    public @ResponseBody RestaurantDto getRestaurantById(@Valid @PathVariable int restaurantId) {
        return RestaurantDto.fromEntity(this.restaurantService.getRestaurantById(restaurantId));
    }

    @PostMapping("/restaurants")
    public @ResponseBody RestaurantDto addRestaurant(@Valid @RequestBody AddRestaurantDto body) {
        return RestaurantDto.fromEntity(this.restaurantService.addRestaurant(body.getNom(), body.getAdresse()));
    }

    @PutMapping("/restaurants/{restaurantId}")
    public @ResponseBody RestaurantDto updateRestaurant(@Valid @PathVariable int restaurantId, @Valid @RequestBody UpdateRestaurantDto body) {
        return RestaurantDto.fromEntity(this.restaurantService.updateRestaurant(restaurantId, body.getNom(), body.getAdresse()));
    }

}
