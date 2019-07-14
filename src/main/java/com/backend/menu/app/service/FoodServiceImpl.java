package com.backend.menu.app.service;

import com.backend.menu.app.dto.ItemDTO;
import com.backend.menu.app.model.FoodEntity;
import com.backend.menu.app.repository.FoodRepository;
import com.google.api.client.util.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    private final String AT_06_PM_EVERY_DAY = "0 0 6 * * *";

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public ItemDTO saveFood(ItemDTO itemDTO) {

        ModelMapper modelMapper = new ModelMapper();
        FoodEntity foodEntity = modelMapper.map(itemDTO, FoodEntity.class);

        foodRepository.save(foodEntity);

        return itemDTO;
    }

    @Override
    public List<FoodEntity> getAllFood() {

        return  Lists.newArrayList(foodRepository.findAll());
    }

    @Override
    @Scheduled(cron = AT_06_PM_EVERY_DAY)
    public void deleteFood() {

        Lists.newArrayList(foodRepository.findAll())
                .stream()
                .filter(FoodEntity::getDone)
                .forEach(foodEntity -> foodRepository.delete(foodEntity));

    }

    @Override
    public List<ItemDTO> updateStatusFood(List<ItemDTO> itemDTOS) {

        itemDTOS.forEach(food -> foodRepository.findByName(food.getName())
                .stream()
                .findFirst()
                .ifPresent(entity -> {
                    entity.setDone(!food.getDone());
                    foodRepository.save(entity);
                }));

        return itemDTOS;
    }
}
