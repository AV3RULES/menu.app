package com.backend.menu.app.service;

import com.backend.menu.app.dto.ItemDTO;
import com.backend.menu.app.model.FoodEntity;

import java.util.List;

public interface FoodService {

    List<FoodEntity> getAllFood();

    ItemDTO saveFood(ItemDTO itemDTO);

    List<ItemDTO> updateStatusFood(List<ItemDTO> foodNames);

    void deleteFood();
}
