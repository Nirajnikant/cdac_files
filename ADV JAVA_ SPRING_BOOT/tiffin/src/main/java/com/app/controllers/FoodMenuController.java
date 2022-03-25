package com.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CuisineType;
import com.app.model.FoodMenu;
import com.app.model.MealType;
import com.app.model.MenuItem;
import com.app.services.FoodMenuService;

@RestController
public class FoodMenuController {
    private FoodMenuService foodMenuService;

    @Autowired
    public FoodMenuController(FoodMenuService foodMenuService) {
        this.foodMenuService = foodMenuService;
    }

    @PostMapping(value = "/restaurant/menu")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenuByRestaurantId(final String menuId, final String restaurantId,
                                      final List<MenuItem> menuItemList) {
        foodMenuService.addMenuByRestaurantId(menuId, restaurantId, menuItemList);
    }

    @GetMapping(value = "/menu/{menuId}")
    public FoodMenu getMenuById(final String menuId) {
        return foodMenuService.getMenuById(menuId);
    }

    @GetMapping(value = "/restaurant/{restaurantId}/menu")
    public FoodMenu getMenuByRestaurantId(final String restaurantId) {
        return foodMenuService.getMenuByRestaurantId(restaurantId);
    }

    @PutMapping(value = "/menu/items")
    public void addMenuItemsByMenuId(final String menuId, final List<MenuItem> menuItemList) {
        foodMenuService.addMenuItemsByMenuId(menuId, menuItemList);
    }

    @PutMapping(value = "/restaurant/{restaurantId}/menu/items")
    public void addMenuItemsByRestaurantId(final String restaurantId, final List<MenuItem> menuItemList) {
        foodMenuService.addMenuItemsByRestaurantId(restaurantId, menuItemList);
    }

    @GetMapping(value = "/restaurant/{restaurantId}/menu/cuisine/{cuisineType}")
    public List<MenuItem> getMenuItemsByRestaurantIdAndCuisine(final String restaurantId,
                                                               final CuisineType cuisineType) {
        return foodMenuService.getMenuItemsByRestaurantIdAndCuisine(restaurantId, cuisineType);
    }

    @GetMapping(value = "/restaurant/{restaurantId}/menu/meal/{mealType}")
    public List<MenuItem> getMenuItemsByRestaurantIdAndMealType(final String restaurantId,
                                                                final MealType mealType) {
        return foodMenuService.getMenuItemsByRestaurantIdAndMealType(restaurantId, mealType);
    }
}
