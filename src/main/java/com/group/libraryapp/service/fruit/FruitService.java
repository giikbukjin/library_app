package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.fruit.FruitCountResponse;
import com.group.libraryapp.dto.fruit.FruitPriceResponse;
import com.group.libraryapp.dto.fruit.FruitRequest;
import com.group.libraryapp.dto.fruit.FruitResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitRequest request) {
        fruitRepository.save(
                new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice())
        );
    }

    public void updateFruit(FruitRequest request) { // 과일 판매 여부 업데이트
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        fruit.updateIsSold(true);
        fruitRepository.save(fruit);
    }

    public FruitResponse getFruitStat(String name) {
        List<Fruit> fruits = fruitRepository.findByName(name);
        long salesAmount = 0;
        long notSalesAmount = 0;

        for (Fruit fruit : fruits) {
            if (fruit.isSold()) { // 판매됨
                salesAmount += fruit.getPrice();
            } else { // 판매되지 않음
                notSalesAmount += fruit.getPrice();
            }
        }
        return new FruitResponse(salesAmount, notSalesAmount);
    }

    public FruitCountResponse getFruitCount(String name) {
        long fruitCount = fruitRepository.countByName(name);
        return new FruitCountResponse(fruitCount);
    }

    public List<FruitPriceResponse> getFruitPrice(String option, Long price) {
        List<Fruit> fruits;

        if (option.equals("GTE")) {
            fruits = fruitRepository.findByPriceGreaterThanEqual(price);
        } else if (option.equals("LTE")){
            fruits = fruitRepository.findByPriceLessThanEqual(price);
        } else {
            throw new IllegalArgumentException();
        }
        return fruits.stream()
                .filter(fruit -> !fruit.isSold())
                .map(fruit -> new FruitPriceResponse(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate()))
                .collect(Collectors.toList());
    }
}
