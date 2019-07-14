package com.backend.menu.app.controller;

import com.backend.menu.app.dto.ItemDTO;
import com.backend.menu.app.service.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodServiceImpl foodService;

    @GetMapping()
    public ResponseEntity getAllFood() {

        return new ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity saveFood(@RequestBody ItemDTO itemDTO) {

        return new ResponseEntity<>(foodService.saveFood(itemDTO),  HttpStatus.CREATED);
    }

    @PatchMapping()
    @ResponseBody
    public ResponseEntity updateStatusFood(@RequestBody List<ItemDTO> foodNames) {

        return new ResponseEntity<>(foodService.updateStatusFood(foodNames),  HttpStatus.OK);
    }

    @DeleteMapping()
    @ResponseBody
    public ResponseEntity deleteFood() {

        foodService.deleteFood();
        return new ResponseEntity<>("Deleted",  HttpStatus.OK);
    }
}

