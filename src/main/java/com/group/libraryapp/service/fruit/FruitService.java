package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.fruit.FruitRequest;
import com.group.libraryapp.dto.fruit.FruitResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitRequest request) {
        fruitRepository.saveFruit(request);
    }

    public void updateFruit(FruitRequest request) {
        if (fruitRepository.isFruitNotExitById(request)) {
            throw new IllegalStateException();
        }
        fruitRepository.fruitUpdate(request);
    }

    public FruitResponse getFruitStat(String name) {
        if (fruitRepository.isFruitNotExitByName(name)) {
            throw new IllegalStateException();
        }
        FruitResponse response = new FruitResponse();
        response.setSalesAmount(fruitRepository.getSoldSum());
        response.setNotSalesAmount(fruitRepository.getNotSoldSum());
        return response;
    }
}
