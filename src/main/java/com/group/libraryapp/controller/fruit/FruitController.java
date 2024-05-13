package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.FruitRequest;
import com.group.libraryapp.dto.fruit.FruitResponse;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitRequest request) {
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitRequest request) {
        fruitService.updateFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitResponse getFruitStat(@RequestParam String name) {
        return fruitService.getFruitStat(name);
    }
}
