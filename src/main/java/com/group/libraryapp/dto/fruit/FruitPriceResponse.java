package com.group.libraryapp.dto.fruit;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FruitPriceResponse {
    private String name;
    private Long price;
    private LocalDate warehousingDate;

    public FruitPriceResponse(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }
}
