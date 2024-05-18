package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    List<Fruit> findByName(String name);

    long countByName(String name);

    List<Fruit> findByPriceGreaterThanEqual(Long price);
    List<Fruit> findByPriceLessThanEqual(Long price);
}