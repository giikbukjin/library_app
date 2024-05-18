package com.group.libraryapp.dto.fruit;

import lombok.Getter;

@Getter
public class FruitResponse {
    private long salesAmount;
    private long notSalesAmount;

    public FruitResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }
}

