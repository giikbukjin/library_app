package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.fruit.FruitRequest;
import org.springframework.stereotype.Repository;

@Repository
public class FruitMemoryRepository implements FruitRepository {

    @Override
    public void saveFruit(FruitRequest request) {

    }

    @Override
    public Boolean isFruitNotExitById(FruitRequest request) {
        return null;
    }

    @Override
    public Boolean isFruitNotExitByName(String name) {
        return null;
    }

    @Override
    public void fruitUpdate(FruitRequest request) {

    }

    @Override
    public long getSoldSum() {
        return 0;
    }

    @Override
    public long getNotSoldSum() {
        return 0;
    }
}
