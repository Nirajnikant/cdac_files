package com.app.datastore;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.app.model.Restaurant;

import lombok.Getter;

@Component
@Getter
public class RestaurantData {
    private Map<String, Restaurant> restaurantById = new HashMap<>();
    private Map<String, List<String>> restaurantIdsByName = new HashMap<>();
    private Map<String, List<String>> restaurantIdsByCity = new HashMap<>();
}
