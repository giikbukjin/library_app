package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.FruitCountResponse;
import com.group.libraryapp.dto.fruit.FruitPriceResponse;
import com.group.libraryapp.dto.fruit.FruitRequest;
import com.group.libraryapp.dto.fruit.FruitResponse;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/v1/fruit/count")
    public FruitCountResponse getFruitCount(@RequestParam String name) {
        return fruitService.getFruitCount(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitPriceResponse> getFruitPrice(
            @RequestParam("option") String option,
            @RequestParam("price") Long price
    ) {
        return fruitService.getFruitPrice(option, price);
    }
}
