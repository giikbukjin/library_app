package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.fruit.FruitRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository {
    void saveFruit(FruitRequest request);

    Boolean isFruitNotExitById(FruitRequest request);

    Boolean isFruitNotExitByName(String name);

    void fruitUpdate(FruitRequest request);

    long getSoldSum();

    long getNotSoldSum();
}